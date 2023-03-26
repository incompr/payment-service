package payment.service.skf.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import payment.service.skf.models.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>  {

//    @Autowired
//    @Lazy
//    AccountRepository accountRepository;
//
//    @Autowired
//    OperationsRepository operationsRepository;
//
//    public void getBalance() {
//        System.out.println("<-- Balance -->");
//        //clientRepository.findAll().forEach(x -> System.out.println(x));
//        clientRepository.getReferenceById(2L);
//    }
//
//    public void putMoney(){
//        System.out.println("<-- Put Money -->");
//        clientRepository.save(new Client(10,555888));
//    }
//    public void takeMoney() {
//        System.out.println("<-- Take Money -->");
//        clientRepository.save(new Client(11,334455));
//    }
//    public void getOperationList() {
//        System.out.println("<-- Get Operation List -->");
//        operationsRepository.findAll();
//    }
}


