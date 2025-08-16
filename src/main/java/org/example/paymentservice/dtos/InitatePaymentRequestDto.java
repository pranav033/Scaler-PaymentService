package org.example.paymentservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitatePaymentRequestDto {

    private Long amount;
    private String orderID;
    private String phoneNo;
    private String name;
    private String email;


}
