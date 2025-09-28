import java.time.LocalDate;

public class Reservation {
    private int reservationId;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private Customer customer;
    Location pickUpLocation;
    Location dropLocation;
    ReservationStatus status;

    public Reservation(int reservationId, Vehicle vehicle, LocalDate startDate, LocalDate endDate, Customer customer) {
        this.reservationId = reservationId;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
