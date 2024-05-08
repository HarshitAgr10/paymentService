package dev.harshit.paymentservice.services;

import dev.harshit.paymentservice.services.paymentgateway.PaymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewaySelector paymentGatewaySelector;

    public PaymentService (PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }

    public String generatePaymentLink() {
        // Write logic to add details in the database

        return paymentGatewaySelector
                .getPaymentGateway()
                .generatePaymentLink();
    }
}
