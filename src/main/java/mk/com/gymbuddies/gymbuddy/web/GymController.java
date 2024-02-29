package mk.com.gymbuddies.gymbuddy.web;

import mk.com.gymbuddies.gymbuddy.model.WorkoutEntity;
import mk.com.gymbuddies.gymbuddy.model.WorkoutType;
import mk.com.gymbuddies.gymbuddy.repository.InstructorRepository;
import mk.com.gymbuddies.gymbuddy.repository.MemberRepository;
import mk.com.gymbuddies.gymbuddy.repository.UserRepository;
import mk.com.gymbuddies.gymbuddy.repository.WorkoutRepository;
import mk.com.gymbuddies.gymbuddy.service.GymService;
import mk.com.gymbuddies.gymbuddy.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping()
public class GymController {

    private final UserRepository userRepository;
    private final InstructorRepository instructorRepository;
    private final MemberRepository memberRepository;
    private final WorkoutRepository workoutRepository;
    @Autowired
    private GymService gymService;
    private WorkoutService workoutService;

    public GymController(UserRepository userRepository, InstructorRepository instructorRepository, MemberRepository memberRepository, WorkoutRepository workoutRepository, WorkoutService workoutService) {
        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
        this.memberRepository = memberRepository;
        this.workoutRepository = workoutRepository;
        this.workoutService = workoutService;
    }


    @GetMapping("/gyms")
    private String getGymPage(Principal principal, Model model,
                              @RequestParam(required = false) String instructor) {
        instructorRepository.findByUserfk(userRepository.findByUsername(principal.getName()).getId()).ifPresent(i -> {
            model.addAttribute("instructor", "true");

        });
        memberRepository.findByUserfk(userRepository.findByUsername(principal.getName()).getId()).ifPresent(i -> {
            model.addAttribute("member", "true");

        });
        model.addAttribute("instructors", gymService.listAllInstructors());
        model.addAttribute("workouts",workoutService.listAllWorkouts(userRepository.findByUsername(principal.getName()).getId()));
        return "main";
    }

    @GetMapping("/")
    private String getHomePage(Model model) {
        return "home";
    }

    @GetMapping("/gyms/book")
    private String showBookWorkout(Model model) {
        model.addAttribute("workoutType", WorkoutType.values());
        model.addAttribute("gyms", gymService.findAll());
        return "book-workout";
    }

    @PostMapping("/gyms/book")
    private String bookWorkout(Model model, Principal principal, @RequestParam int durationinminutes,
                               @RequestParam WorkoutType type,
                               @RequestParam int price,
                               @RequestParam Long gym
    ) {
        String name = principal.getName();
        System.out.println(type);
        workoutRepository.save(new WorkoutEntity(durationinminutes, type.name(), price, userRepository.findByUsername(name).getId(), gym.intValue()));
        return "redirect:/gyms?succesfully";
    }
}