package mk.com.gymbuddies.gymbuddy.web;

import mk.com.gymbuddies.gymbuddy.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // You can add more controller methods here if needed
}