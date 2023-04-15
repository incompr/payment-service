package payment.service.skf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payment.service.skf.models.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>  {


}


