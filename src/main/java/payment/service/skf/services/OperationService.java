package payment.service.skf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import payment.service.skf.exception.AccountNotFoundException;
import payment.service.skf.exception.OperationListIsEmptyException;
import payment.service.skf.models.Account;
import payment.service.skf.models.Operation;
import payment.service.skf.repository.AccountRepository;
import payment.service.skf.repository.OperationRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class OperationService {

    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository, AccountRepository accountRepository) {
        this.operationRepository = operationRepository;
        this.accountRepository = accountRepository;

    }

    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public List<Operation> findOne(int id) throws AccountNotFoundException {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isEmpty()) {
            throw new AccountNotFoundException();
        }
        List<Operation> operationList = operationRepository.findAll().stream()
                .filter(operation -> operation.getAccountId() == id)
                .collect(Collectors.toList());

        if (operationList.isEmpty()) {
            throw new OperationListIsEmptyException();
        } else {
            return operationList;
        }
    }

    @Transactional
    public void save(Operation operation) {
        operationRepository.save(operation);
    }

}

