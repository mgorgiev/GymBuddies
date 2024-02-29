package mk.com.gymbuddies.gymbuddy.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.com.gymbuddies.gymbuddy.model.InstructorEntity;
import mk.com.gymbuddies.gymbuddy.model.MemberEntity;
import mk.com.gymbuddies.gymbuddy.model.UserEntity;
import mk.com.gymbuddies.gymbuddy.repository.InstructorRepository;
import mk.com.gymbuddies.gymbuddy.repository.MemberRepository;
import mk.com.gymbuddies.gymbuddy.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final InstructorRepository instructorRepository;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, MemberRepository memberRepository, InstructorRepository instructorRepository) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
        this.instructorRepository = instructorRepository;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "login.html";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        Optional<UserEntity>currentUser=userRepository.findByUsernameAndPassword(request.getParameter("username"), request.getParameter("password"));
        if(!currentUser.isPresent()) return "redirect:/login?loginEror";
        request.getSession().setAttribute("user", currentUser.get());
        return "redirect:/home";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        return "register.html";
    }
    @PostMapping("/register")
    public String registerUser(Model model, @RequestParam String password,
                               @RequestParam String username, @RequestParam String firstname,
                               @RequestParam String lastname,@RequestParam String email,
                               @RequestParam String phonenumber,@RequestParam String gender) {
        UserEntity currentUser=userRepository.findByUsername(username);
        if(currentUser==null){
            UserEntity newUser=new UserEntity(username,password, firstname, lastname, email, phonenumber, gender);
            userRepository.save(newUser);
            return "redirect:/auth/login";
        }
        return "redirect:/auth/register?error";
    }
    @GetMapping("/register-member")
    public String showRegisterMember(Model model,HttpSession session) {
        model.addAttribute("currentUser",(UserEntity) session.getAttribute("user"));

        return "register-member";
    }
    @GetMapping("/register-instructor")
    public String showRegisterInstructor(Model model, Principal principal) {
        return "register-instructor";
    }
    @PostMapping("/register-instructor")
    public String registerInstructor(Model model, Principal principal,@RequestParam int priceperworkout) {
        String name=principal.getName();
        instructorRepository.save(new InstructorEntity(LocalDate.now(),userRepository.findByUsername(name).getId(),priceperworkout));
        return "redirect:/gyms?instructor=true";
    }
    @PostMapping("/register-member")
    public String registerMember(Model model, Principal principal,@RequestParam int months) {
        String name=principal.getName();
        memberRepository.save(new MemberEntity(LocalDate.now(),LocalDate.now().plusMonths(months),userRepository.findByUsername(name).getId()));
        return "redirect:/gyms?member=true";
    }
}