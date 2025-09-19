import models.PaymentMode;
import services.PaymentProcessorService;
import services.PaymentProcessorServiceImpl;

public class Main {
    public static void main(String[] args) {
        PaymentProcessorService processor = new PaymentProcessorServiceImpl();
        double amount = 200.50;

        processor.checkout(PaymentMode.PAYPAL, amount);
    }
}
