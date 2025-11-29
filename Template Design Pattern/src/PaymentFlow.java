public abstract class PaymentFlow {
    public abstract void validateRequest();
    public abstract void calculateFees();
    public abstract void debitAmount();
    public abstract void creditAmount();

    //this is template which defines the order of the steps to exceute the task
    public final void sendMoney(){
        validateRequest();
        debitAmount();
        calculateFees();
        creditAmount();
    }
}
