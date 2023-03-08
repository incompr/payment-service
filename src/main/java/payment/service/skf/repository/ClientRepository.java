package payment.service.skf.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import payment.service.skf.models.Account;

public class ClientRepository {

    @Autowired
    @Lazy
    ClientRepository clientRepository;

    public void getBalance() {
        System.out.println("<-- Balance -->");
        //clientRepository.findAll().forEach(x -> System.out.println(x));
        clientRepository.getReferenceById(2L);
    }

    public void putMoney() {
        System.out.println("<-- Put Money -->");
        clientRepository.save(new Account(10, 555888));
    }

    public void takeMoney() {
        System.out.println("<-- Take Money -->");
        clientRepository.save(new Account(11, 334455));
    }

}
