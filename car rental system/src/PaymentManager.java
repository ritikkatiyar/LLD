import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentManager {
    private PaymentStrategy paymentStrategy;
    private final Map<Integer,Payment> paymentMap=new ConcurrentHashMap<>();

    public PaymentManager(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    public Payment makePayment(Bill bill,double payableAmount){
        Payment payment=paymentStrategy.processPayment(bill,payableAmount);
        paymentMap.put(payment.getPaymentId(),payment);
        return payment;
    }
    public List<Payment> getPaymentForBill(int billId){
        return paymentMap.values().stream().filter(e->e.getBillId()==billId)
                .toList();
    }
    public Optional<Payment> getPayment(int paymentId){
        return Optional.ofNullable(paymentMap.get(paymentId));
    }
    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
}
