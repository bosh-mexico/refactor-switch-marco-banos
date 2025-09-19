package services;

import models.PaymentMode;

public class PaymentProcessorServiceImpl implements PaymentProcessorService {

    private double lastTransactionFee = 0.0;

    @Override
    public void checkout(PaymentMode mode, double amount) {
        switch (mode) {
            case PAYPAL -> processPayPal(amount);
            case GOOGLEPAY -> processGooglePay(amount);
            case CREDITCARD -> processCreditCard(amount);
            default -> handleInvalidPayment();
        }
    }

    public void processPayPal(double amount) {
        // Simulation: 3.5% tax + $0.30 fixed tax
        double fee = amount * 0.035 + 0.30;
        lastTransactionFee = fee;
        double total = amount + fee;
        System.out.println("Processing PayPal payment of $" + String.format("%.2f", amount));
    }

    public void processGooglePay(double amount) {
        // Simulation: 2.9% tax
        double fee = amount * 0.029;
        lastTransactionFee = fee;
        double total = amount + fee;
        System.out.println("Processing GooglePay payment of $" + String.format("%.2f", amount));
    }

    public void processCreditCard(double amount) {
        // Simulation: 2.5% + $0.50 fixed tax
        double fee = amount * 0.025 + 0.50;
        lastTransactionFee = fee;
        double total = amount + fee;
        System.out.println("Processing Credit Card payment of $" + String.format("%.2f", amount));
    }

    public void handleInvalidPayment() {
        System.out.println("Invalid payment mode selected!");
    }

    public double getLastTransactionFee() {
        return lastTransactionFee;
    }
}
