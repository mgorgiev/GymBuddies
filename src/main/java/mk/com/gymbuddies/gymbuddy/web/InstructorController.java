package mk.com.gymbuddies.gymbuddy.web;

import mk.com.gymbuddies.gymbuddy.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    // You can add more controller methods here if needed
}