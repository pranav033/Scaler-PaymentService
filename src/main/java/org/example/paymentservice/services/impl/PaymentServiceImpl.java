package org.example.paymentservice.services.impl;

import org.example.paymentservice.paymentgateways.PaymentGateway;
import org.example.paymentservice.paymentgateways.PaymentGatewayChooserStrategy;
import org.example.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    @Override
    public String iniatePayment(Long amount, String orderID, String phoneNo, String name, String email) {
        PaymentGateway paymentGateway = paymentGatewayChooserStrategy.choosePaymentGateway();
        return paymentGateway.generatePaymentLink(amount, orderID, phoneNo, name, email);
    }
}
