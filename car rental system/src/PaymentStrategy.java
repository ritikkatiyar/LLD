import java.util.concurrent.atomic.AtomicInteger;

public interface PaymentStrategy {
    public Payment processPayment(Bill bill,double payableAmount);
}
