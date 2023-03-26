package payment.service.skf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payment.service.skf.models.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
