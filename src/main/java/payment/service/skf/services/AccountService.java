package payment.service.skf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import payment.service.skf.exception.AccountNotFoundException;
import payment.service.skf.models.Account;
import payment.service.skf.repository.AccountRepository;

import java.util.Optional;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

    }

    public Account findOne(int id) throws AccountNotFoundException {
        Optional<Account> foundAccount = accountRepository.findById(id);
        return foundAccount.orElseThrow(AccountNotFoundException::new);
    }

    @Transactional
    public void save(Account account) {
        accountRepository.save(account);
    }
}
