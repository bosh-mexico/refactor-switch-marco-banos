package services;

import models.PaymentMode;

public interface PaymentProcessorService {

    void checkout(PaymentMode mode, double amount);

    void processPayPal(double amount);

    void processGooglePay(double amount);

    void processCreditCard(double amount);

    void handleInvalidPayment();
}
