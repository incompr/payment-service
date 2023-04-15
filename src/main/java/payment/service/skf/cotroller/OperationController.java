package payment.service.skf.cotroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import payment.service.skf.exception.AccountNotFoundException;
import payment.service.skf.exception.NegativeAmountException;
import payment.service.skf.exception.NotEnoughMoneyException;
import payment.service.skf.exception.OperationListIsEmptyException;
import payment.service.skf.models.Account;
import payment.service.skf.models.Operation;
import payment.service.skf.services.AccountService;
import payment.service.skf.services.OperationService;
import payment.service.skf.utils.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operation")
public class OperationController {

    private final OperationService operationService;
    private final AccountService accountService;
    //  private final ModelMapper modelMapper;

    @Autowired
    public OperationController(OperationService operationService, AccountService accountService, ModelMapper modelMapper) {
        this.operationService = operationService;
        this.accountService = accountService;
        //     this.modelMapper = modelMapper;
    }

    @GetMapping("/getOperationList")
    public List<Operation> getOperationList() {
        return operationService.findAll();
    }

    @GetMapping("/getOperationList/{id}")
    public List<Operation> getOperationList(@PathVariable("id") int id) throws AccountNotFoundException, OperationListIsEmptyException {
        return operationService.findOne(id);
    }

    @GetMapping("/getOperationList/id={id}&timeStamp={timestamp}")
    public List<Operation> getOperationList(@PathVariable("id") int id, @PathVariable("timestamp") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestamp) throws AccountNotFoundException, OperationListIsEmptyException {
        List<Operation> operationList = operationService.findOne(id);

        operationList = operationList.stream()
                .filter(operation -> operation.getTimestamp().isAfter(timestamp))
                .collect(Collectors.toList());

        return operationList;
    }

    @Transactional
    @GetMapping("/sendMoney/senderId={senderId}&recipientId={recipientId}&amount={amount}")
    public ResponseEntity sendMoney(@PathVariable("senderId") int senderId, @PathVariable("recipientId") int recipientId, @PathVariable("amount") long amount) throws NegativeAmountException, AccountNotFoundException, NotEnoughMoneyException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        Account senderAccount = accountService.findOne(senderId);
        Account recipientAccount = accountService.findOne(recipientId);
        senderAccount.takeMoney(amount);
        accountService.save(senderAccount);
        recipientAccount.putMoney(amount);
        accountService.save(recipientAccount);
        operationService.save(new Operation(recipientId, 3, amount, senderId, LocalDateTime.now()));
        return new ResponseEntity(1, "Success");
    }

    @ExceptionHandler
    private ResponseEntity handleException(AccountNotFoundException ex) {
        return new ResponseEntity(-1, "Account no found by id");
    }

    @ExceptionHandler
    private ResponseEntity handleException(NotEnoughMoneyException ex) {
        return new ResponseEntity(0, "Not enough money");
    }

    @ExceptionHandler
    private ResponseEntity handleException(OperationListIsEmptyException ex) {
        return new ResponseEntity(-1, "Operation List Is empty for this account id");
    }

    @ExceptionHandler
    private ResponseEntity handleException(NegativeAmountException ex) {
        return new ResponseEntity(0, "Negative amount cannot be added");
    }

}
