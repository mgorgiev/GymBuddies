package mk.com.gymbuddies.gymbuddy.service;

import mk.com.gymbuddies.gymbuddy.model.WorkoutEntity;
import mk.com.gymbuddies.gymbuddy.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    // You can add more service methods here if needed

    public List<WorkoutEntity> listAllWorkouts(int id) {
        return workoutRepository.findWorkoutEntitiesByMemberfk(id);
    }

}