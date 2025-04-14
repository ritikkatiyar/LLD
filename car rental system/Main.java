import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create vehicles
        Vehicle car1 = new Vehicle(1, VehicleType.CAR, VehicleStatus.ACTIVE);
        Vehicle bike1 = new Vehicle(2, VehicleType.BIKE, VehicleStatus.ACTIVE);

        // Create vehicle inventory and add vehicles
        VehicleInventory inventory = new VehicleInventory();
        inventory.addVehicle(car1);
        inventory.addVehicle(bike1);

        // Create store location
        Location location = new Location("Gurgaon", "Haryana", "122001");

        // Create empty reservation list
        List<Reservation> reservations = new ArrayList<>();

        // Create store
        Store store = new Store(1, inventory, location, reservations);

        // Create customer
        Customer customer = new Customer(1, "Ritik Sharma", "9876543210", "Sector 21, Gurgaon", "DL-0123456");

        // Create a reservation
        Reservation reservation = new Reservation(
                1,
                car1,
                LocalDate.of(2025, 4, 15),
                LocalDate.of(2025, 4, 20),
                customer
        );

        // Add reservation to the store
        store.addReservation(reservation);

        // Output
        System.out.println("Reservation made successfully for: " + reservation.getCustomer().getName());
        System.out.println("Reserved Vehicle: " + reservation.getVehicle().getVehicleType() + " " + reservation.getVehicle().getId());
        System.out.println("From: " + reservation.getStartDate() + " To: " + reservation.getEndDate());
        System.out.println("Store Location: " + store.getLocation().getAddress());
    }
}
