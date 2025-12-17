import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class VehicleInventoryManager {
    //vehicleid->vehicle
    private final ConcurrentHashMap<Integer,Vehicle> vehicles=new ConcurrentHashMap<>();
    //vehicleId->list of revervationIds
    private final ConcurrentHashMap<Integer, List<Integer>> vehicleBookingIds=new ConcurrentHashMap<>();
    //pre vehicle lock
    private final ConcurrentHashMap<Integer, ReentrantLock> vehicleLocks=new ConcurrentHashMap<>();
    private ReservationRepo reservationRepo;

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getVehicleId(),vehicle);
    }
    public Optional<Vehicle> getVehicle(int vehicleId){
        return Optional.ofNullable(vehicles.get(vehicleId));
    }

    public void setReservationRepo(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }


    private ReentrantLock lockForVehicle(int vehicleId){
        vehicleLocks.putIfAbsent(vehicleId,new ReentrantLock());
        return vehicleLocks.get(vehicleId);
    }
    //check availablity
    public boolean isAvailable(int vehicleId, LocalDate from,LocalDate to){
        Vehicle vehicle=vehicles.get(vehicleId);

        if(vehicle==null) return false;
        if(vehicle.getVehicleStatus()==VehicleStatus.MAINTENANCE) return false;

        DateInterval requested=new DateInterval(from,to);
        List<Integer> reservationIds=vehicleBookingIds.get(vehicleId);
        if(reservationIds==null || reservationIds.isEmpty()) return true;

        for(int reservationId:reservationIds){
            Reservation reservation=reservationRepo.findById(reservationId).get();
            LocalDate bookedFrom=reservation.getBookedFrom();
            LocalDate bookedTill=reservation.getBookedTo();
            DateInterval bookedInterval=new DateInterval(bookedFrom,bookedTill);
            if(bookedInterval.overlaps(requested)){
                return false;
            }
        }
        return true;
    }

    /// ////////////atomic booking
    public boolean reserve(int vehicleId,int reservationId,LocalDate from ,LocalDate to){
        ReentrantLock lock=lockForVehicle(vehicleId);
        lock.lock();
        try{
            if(!isAvailable(vehicleId,from,to)){
                return false;
            }
            vehicleBookingIds.putIfAbsent(vehicleId,new ArrayList<>());
            vehicleBookingIds.get(vehicleId).add(reservationId);

            vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.BOOKED);
            return true;
        }finally {
            lock.unlock();
        }
    }
    /// //// atmomic release
    public void release(int vehicleId,int reservationId){
        ReentrantLock lock=lockForVehicle(vehicleId);
        lock.lock();

        try{
            //remove reservation id
            List<Integer> ids=vehicleBookingIds.get(vehicleId);
            if(ids!=null){
                ids.remove(Integer.valueOf(reservationId));
            }
            //if no more bookings->available
            List<Integer> stillBooked=vehicleBookingIds.get(vehicleId);
            if(stillBooked==null || stillBooked.isEmpty()){
                vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.AVAILABLE);
            }
        }finally {
            lock.unlock();
        }
    }
    /// ////////////search

    public List<Vehicle> getAvailableVehicles(VehicleType type,LocalDate from,LocalDate to){
        return vehicles.values().stream().filter(vehicle -> vehicle.getVehicleType()==type)
                .filter(v->isAvailable(v.getVehicleId(),from,to))
                .collect(Collectors.toList());
    }
}
