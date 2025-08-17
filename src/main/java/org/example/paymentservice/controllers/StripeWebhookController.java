package org.example.paymentservice.controllers;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook/stripe")
public class StripeWebhookController {

    public void handleStripeWebhook(@RequestBody String event) {
        // Logic to handle Stripe webhook events
        // This method will be called when a webhook event is received from Stripe
        // You can process the event and update your system accordingly
        System.out.println("Hello from Stripe Webhook Controller");
        System.out.println("Received event: " + event);
        // Add your event handling logic here
        // For example, you might want to verify the event, update order status, etc.
        // Note: Make sure to handle different event types appropriately
        // For example, you can check the event type and perform actions based on it
    }
}
