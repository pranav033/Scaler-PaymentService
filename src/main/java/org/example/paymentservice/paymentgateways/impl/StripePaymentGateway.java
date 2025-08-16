package org.example.paymentservice.paymentgateways.impl;

import org.example.paymentservice.paymentgateways.PaymentGateway;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink(Long amount, String orderID, String phoneNo, String name, String email) {
        // Logic to generate a payment link using Stripe's API
        return "";
    }

    // Additional methods specific to Stripe can be added here
}
