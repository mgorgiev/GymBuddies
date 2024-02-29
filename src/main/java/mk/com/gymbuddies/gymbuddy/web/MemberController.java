package mk.com.gymbuddies.gymbuddy.web;

import mk.com.gymbuddies.gymbuddy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // You can add more controller methods here if needed
}
