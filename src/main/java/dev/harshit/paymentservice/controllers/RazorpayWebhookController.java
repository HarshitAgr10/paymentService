package dev.harshit.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {

    @PostMapping("/razorpayWebhook")
    public void paymentDone(@RequestBody Object object) {
        System.out.println(object);

        // Update the payment Database here
    }
}


// Webhook URL
// Razorpay should call this webhook url when the payment is completed or failed or refund is initiated

// Local tunnel to generate a temporary public url which can transfer request to server on local system
// Run this command on cmd ->  lt --port 8080
// Create a webhook url on Razorpay dashboard using -> <URL>/razorpayWebhook
