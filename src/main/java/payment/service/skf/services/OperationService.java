package payment.service.skf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import payment.service.skf.dto.AccountDTO;
import payment.service.skf.models.Account;
import payment.service.skf.models.Operation;
import payment.service.skf.repository.OperationRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OperationService {

    private final OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public List<Operation> findOne(int id) {
        //  Optional<Account> foundAccount =
        return operationRepository.findAll();

    }
}

