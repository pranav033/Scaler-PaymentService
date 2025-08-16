package org.example.paymentservice.paymentgateways;

import org.example.paymentservice.paymentgateways.impl.RazorpayPaymentGateway;
import org.example.paymentservice.paymentgateways.impl.StripePaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayChooserStrategy {

    @Autowired
    private RazorpayPaymentGateway razorpayPaymentGateway;
    @Autowired
    private StripePaymentGateway stripePaymentGateway;


    public PaymentGateway choosePaymentGateway()
    {
        return razorpayPaymentGateway;
    }


}
