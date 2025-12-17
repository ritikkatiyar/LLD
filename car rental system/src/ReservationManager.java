import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {
    private final VehicleInventoryManager inventory;
    private final ReservationRepo reservationRepo;

    private final AtomicInteger reservationIdGenerator=new AtomicInteger(20000);

    public ReservationManager(VehicleInventoryManager inventory) {
        this.inventory = inventory;
        this.reservationRepo = new ReservationRepo();
    }

    //get reservation
    public Optional<Reservation> findById(int reservationId){
        return reservationRepo.findById(reservationId);
    }


    //create reservation
    public Reservation createReservation(int vehicleId, User user, LocalDate from ,LocalDate to,ReservationType type)
        throws Exception{

        int reservationId=reservationIdGenerator.getAndIncrement();
        boolean reserved=inventory.reserve(vehicleId,reservationId,from,to);

        if(!reserved){
            throw new RuntimeException("Vehicle not available for selected dates");
        }
        Reservation reservation=new Reservation(reservationId,vehicleId, user.getUserId(), from,to,type);
        reservationRepo.save(reservation);
        return reservation;
    }
    //cancel reservation
    public void cancelReservation(int reservationId){
        Optional<Reservation> opt=reservationRepo.findById(reservationId);
        if(!opt.isPresent()){
            throw new RuntimeException("Reservation not found");
        }
        Reservation r=opt.get();
        r.setReservationStatus(ReservationStatus.CANCELLED);

        inventory.release(r.getVehicleId(),reservationId);
        reservationRepo.remove(reservationId);
    }
    //start trip
    public void startTrip(int reservationId){
        Reservation r=reservationRepo.findById(reservationId).orElseThrow(()->new RuntimeException("Reservation not found"));
        r.setReservationStatus(ReservationStatus.IN_USE);
    }
    //submit vehicle
    public void submitVehicle(int reservationId){
        Reservation r=reservationRepo.findById(reservationId).orElseThrow(()->new RuntimeException("Reservation not found"));

        r.setReservationStatus(ReservationStatus.COMPLETED);

        inventory.release(r.getVehicleId(),reservationId);
    }

    //remove reservation
    public void remove(int reservationId){
        reservationRepo.remove(reservationId);
    }
}
