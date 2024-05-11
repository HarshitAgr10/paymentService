package dev.harshit.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink() {

        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_WDbhyGQe493Dnp", "2jBZWxAiOPtabswhrmqVX980");

            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 1000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);
            paymentLinkRequest.put("expire_by", 1715438608);   // Epoch Time
            paymentLinkRequest.put("reference_id", "TS198945");
            paymentLinkRequest.put("description", "Payment for policy no #23456");

            JSONObject customer = new JSONObject();
            customer.put("contact", "+917050634611");
            customer.put("name", "Harshit Agrawal");
            customer.put("email", "harshithrs1710@gmail.com");
            paymentLinkRequest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);

            paymentLinkRequest.put("callback_url", "https://google.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

            return payment.toString();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return null;
    }
}
