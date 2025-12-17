public interface BillingStrategy {
    public Bill generateBill(Reservation reservation);
}
