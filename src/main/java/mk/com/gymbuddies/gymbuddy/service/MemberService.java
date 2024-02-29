package mk.com.gymbuddies.gymbuddy.service;

import mk.com.gymbuddies.gymbuddy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // You can add more service methods here if needed
}