package mk.com.gymbuddies.gymbuddy.service;

import mk.com.gymbuddies.gymbuddy.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // You can add more service methods here if needed
}
