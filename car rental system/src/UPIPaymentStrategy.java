import java.util.concurrent.atomic.AtomicInteger;

public class UPIPaymentStrategy implements PaymentStrategy{
    private final AtomicInteger paymentIdGenerator=new AtomicInteger(9000);


    @Override
    public Payment processPayment(Bill bill, double payableAmount) {
        Payment payment=new Payment(paymentIdGenerator.getAndIncrement(),bill.getBillId(),
                payableAmount,PaymentMode.UPI,new Date());


        //currently assumption is that payment amount is alaways equals to bill amount
        //no partial scenario
        bill.setBillPaid(true);
        return payment;
    }
}
