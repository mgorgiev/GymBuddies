package mk.com.gymbuddies.gymbuddy.repository;

import mk.com.gymbuddies.gymbuddy.model.GymEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository<GymEntity, Long> {
}

