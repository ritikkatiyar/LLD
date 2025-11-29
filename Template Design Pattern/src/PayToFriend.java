public class PayToFriend extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("validate logic of paymenttofrind");
    }

    @Override
    public void calculateFees() {
        System.out.println("0% fees charget");
    }

    @Override
    public void debitAmount() {

    }

    @Override
    public void creditAmount() {

    }
}
