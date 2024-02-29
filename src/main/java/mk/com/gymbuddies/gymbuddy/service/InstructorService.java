package mk.com.gymbuddies.gymbuddy.service;

import mk.com.gymbuddies.gymbuddy.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    // You can add more service methods here if needed
}