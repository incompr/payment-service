package payment.service.skf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import payment.service.skf.models.Account;
import payment.service.skf.models.Operation;
import payment.service.skf.repository.AccountRepository;
import payment.service.skf.repository.OperationRepository;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;


    @Autowired
    public AccountService(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    public void getBalance() {
        System.out.println("Balance:");
        //clientRepository.findAll().forEach(x -> System.out.println(x));
        accountRepository.getReferenceById(2);
    }

    public void putMoney() {
        System.out.println("Put Money:");
        accountRepository.save(new Account(10, 555888));
    }

    public void takeMoney() {
        System.out.println("Take Money:");
        accountRepository.save(new Account(11, 334455));
    }


    public void getOperationByID(int id) {
        System.out.println("Operation List for AccountId:" + Integer.toString(id) + " ->");
        accountRepository.findAll();////////////
    }

    public Account findOne(int id) throws AccountNotFoundException {
        Optional<Account> foundAccount = accountRepository.findById(id);
        return foundAccount.orElseThrow(AccountNotFoundException::new);
    }
}
