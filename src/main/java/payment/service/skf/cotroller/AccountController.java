package payment.service.skf.cotroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import payment.service.skf.exception.AccountNotFoundException;
import payment.service.skf.exception.NegativeAmountException;
import payment.service.skf.utils.ResponseEntity;
import payment.service.skf.exception.NotEnoughMoneyException;
import payment.service.skf.models.Account;
import payment.service.skf.models.Operation;
import payment.service.skf.services.AccountService;
import payment.service.skf.services.OperationService;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final OperationService operationService;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountController(AccountService accountService, @Lazy OperationService operationService, ModelMapper modelMapper) {
        this.accountService = accountService;
        this.operationService = operationService;
        this.modelMapper = modelMapper;
    }

    @ResponseBody
    @GetMapping(value = "getBalance/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getBalance(@PathVariable("id") int id) throws AccountNotFoundException {
        Account account = accountService.findOne(id);
        operationService.save(new Operation(id));
        return account;
    }

    @ResponseBody
    @GetMapping(value = "takeMoney/id={id}&amount={amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity takeMoney(@PathVariable("id") int id, @PathVariable("amount") long amount) throws AccountNotFoundException, NotEnoughMoneyException {
        Account foundAccount = accountService.findOne(id);
        foundAccount.takeMoney(amount);
        accountService.save(foundAccount);
        return new ResponseEntity(1, "Success");
    }

    @ResponseBody
    @GetMapping(value = "putMoney/id={id}&amount={amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putMoney(@PathVariable("id") int id, @PathVariable("amount") long amount) throws AccountNotFoundException, NegativeAmountException {
        Account foundAccount = accountService.findOne(id);
        foundAccount.putMoney(amount);
        accountService.save(foundAccount);
        //  operationService.save(new Operation(id, 2, amount, id, System.currentTimeMillis()));
        return new ResponseEntity(1, "Success");
    }

    @ExceptionHandler
    private ResponseEntity handleException(NotEnoughMoneyException ex) {
        return new ResponseEntity(0, "Not enough money");
    }

    @ExceptionHandler
    private ResponseEntity handleException(AccountNotFoundException ex) {
        return new ResponseEntity(-1, "Account no found by id");
    }

    @ExceptionHandler
    private ResponseEntity handleException(NegativeAmountException ex) {
        return new ResponseEntity(0, "Negative amount cannot be added");
    }

}
