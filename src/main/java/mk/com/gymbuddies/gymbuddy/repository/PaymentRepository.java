package mk.com.gymbuddies.gymbuddy.repository;

import mk.com.gymbuddies.gymbuddy.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}