package mk.com.gymbuddies.gymbuddy.service;

import mk.com.gymbuddies.gymbuddy.model.UserEntity;
import mk.com.gymbuddies.gymbuddy.repository.InstructorRepository;
import mk.com.gymbuddies.gymbuddy.repository.MemberRepository;
import mk.com.gymbuddies.gymbuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity currentUser=findByUsername(username);
        if(currentUser==null)throw new UsernameNotFoundException(username);
        return User.builder().username(currentUser.getUsername()).
                password(passwordEncoder.encode(currentUser.getPassword()))
                .roles("user").build();
    }

    // You can add more service methods here if needed
}
