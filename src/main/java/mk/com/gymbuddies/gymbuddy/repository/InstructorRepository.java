package mk.com.gymbuddies.gymbuddy.repository;

import mk.com.gymbuddies.gymbuddy.model.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, Long> {
    Optional<InstructorEntity>findByUserfk(int id);
}