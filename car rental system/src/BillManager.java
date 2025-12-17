import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class BillManager {
    private BillingStrategy billingStrategy;
    private final Map<Integer,Bill> billMap=new ConcurrentHashMap<>();

    public BillManager(BillingStrategy billingStrategy){
        this.billingStrategy=billingStrategy;
    }
    public Bill generateBill(Reservation reservation){
        Bill bill=billingStrategy.generateBill(reservation);
        billMap.put(bill.getBillId(),bill);
        return bill;
    }
    public Optional<Bill> getBill(int billId){
        return Optional.ofNullable(billMap.get(billId));
    }
    public void setBillingStrategy(BillingStrategy billingStrategy){
        this.billingStrategy=billingStrategy;
    }

}
