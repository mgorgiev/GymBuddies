package mk.com.gymbuddies.gymbuddy.web;

import mk.com.gymbuddies.gymbuddy.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    // You can add more controller methods here if needed
}
