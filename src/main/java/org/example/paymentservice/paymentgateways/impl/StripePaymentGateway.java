package org.example.paymentservice.paymentgateways.impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.example.paymentservice.paymentgateways.PaymentGateway;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink(Long amount, String orderID, String phoneNo, String name, String email) {
        // Logic to generate a payment link using Stripe's API

        try {
        Stripe.apiKey = "your_api_key_here";

            Price price = getPrice(amount);

            PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        ).setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://www.google.com")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.getUrl();
        }

        catch (StripeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Price getPrice(Long amount) {

        try {
        Stripe.apiKey = "your_api_key_here";

        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("USD")
                        .setUnitAmount(amount)
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                        )
                        .build();


        Price price = Price.create(params);
        return price;
        }

        catch (StripeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // Additional methods specific to Stripe can be added here
}
