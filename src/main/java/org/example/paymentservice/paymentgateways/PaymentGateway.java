package org.example.paymentservice.paymentgateways;

public interface PaymentGateway {

    String generatePaymentLink(Long amount, String orderID, String phoneNo, String name, String email);
}
