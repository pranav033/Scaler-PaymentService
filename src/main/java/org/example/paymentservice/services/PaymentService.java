package org.example.paymentservice.services;


public interface PaymentService {


    String iniatePayment(Long amount, String orderID, String phoneNo, String name, String email);
}
