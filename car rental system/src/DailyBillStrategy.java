import java.time.temporal.ChronoUnit;

public class DailyBillStrategy implements BillingStrategy{
    private final VehicleInventoryManager vehicleInventoryManager;

    public DailyBillStrategy(VehicleInventoryManager vehicleInventoryManager) {
        this.vehicleInventoryManager = vehicleInventoryManager;
    }

    @Override
    public Bill generateBill(Reservation reservation) {

        long days= ChronoUnit.DAYS.between(reservation.getBookedFrom(),reservation.getBookedTo())+1;
        Vehicle vehicle=vehicleInventoryManager.getVehicle(reservation.getVehicleId()).get();

        double rate=vehicle.getDailyRentCost();
        double total=rate*days;

        return new Bill(billIdGenerator.getOrIncrement(),reservation.getReservationId(),total);
    }
}
