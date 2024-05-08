package dev.harshit.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelector {

    private RazorpayGateway razorpayGateway;
    private StripeGateway stripeGateway;

    public PaymentGatewaySelector (RazorpayGateway razorpayGateway,
                                   StripeGateway stripeGateway) {

        this.razorpayGateway = razorpayGateway;
        this.stripeGateway = stripeGateway;
    }
    public PaymentGateway getPaymentGateway() {

        // Logic for choosing the payment gateway goes here
        // Return type here is interface PaymentGateway

        return razorpayGateway;
    }
}
