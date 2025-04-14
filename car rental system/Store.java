import java.util.ArrayList;
import java.util.List;

public class Store {
    private int storeId;
    private VehicleInventory vehicleInventory;
    private Location location;
    private List<Reservation> reservations;

    public Store(int storeId, VehicleInventory vehicleInventory, Location location, List<Reservation> reservations) {
        this.storeId = storeId;
        this.vehicleInventory = vehicleInventory;
        this.location = location;
        this.reservations = reservations != null ? reservations : new ArrayList<>();
    }

    // Getters
    public int getStoreId() {
        return storeId;
    }

    public VehicleInventory getVehicleInventory() {
        return vehicleInventory;
    }

    public Location getLocation() {
        return location;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    // Setters
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setVehicleInventory(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    // Utility methods
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleInventory.addVehicle(vehicle);
    }
}
