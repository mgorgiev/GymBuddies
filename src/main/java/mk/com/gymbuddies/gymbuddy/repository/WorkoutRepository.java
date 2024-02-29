package mk.com.gymbuddies.gymbuddy.repository;

import mk.com.gymbuddies.gymbuddy.model.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long> {
    List<WorkoutEntity> findWorkoutEntitiesByMemberfk(int id);
}