package mk.com.gymbuddies.gymbuddy.service;

import mk.com.gymbuddies.gymbuddy.model.GymEntity;
import mk.com.gymbuddies.gymbuddy.model.UserEntity;
import mk.com.gymbuddies.gymbuddy.repository.GymRepository;
import mk.com.gymbuddies.gymbuddy.repository.InstructorRepository;
import mk.com.gymbuddies.gymbuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;
    private final UserRepository userRepository;
    private final InstructorRepository instructorRepository;

    public GymService(UserRepository userRepository, InstructorRepository instructorRepository) {
        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
    }

    public List<GymEntity> findAll() {
        return gymRepository.findAll();
    }

    public List<UserEntity> listAllInstructors() {
        List<Long>list0fInstructors=instructorRepository.findAll()
                        .stream().map(i->{
                            return (long)i.getUserfk();
                }).collect(Collectors.toList());
        return userRepository.findAllById(list0fInstructors);
    }

    // You can add more service methods here if needed
}