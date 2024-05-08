package dev.harshit.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class StripeGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink() {
        return null;
    }
}
