import java.util.Date;
import java.util.UUID;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final ParkingSpotManager parkingSpotManager;
    private final FareCalculationStrategy fareCalculationStrategy;

    public ParkingService(ParkingLot parkingLot, ParkingSpotManager parkingSpotManager, FareCalculationStrategy fareCalculationStrategy) {
        this.parkingLot = parkingLot;
        this.parkingSpotManager = parkingSpotManager;
        this.fareCalculationStrategy = fareCalculationStrategy;
    }
    public ParkingTicket parkVehicle(Vehicle vehicle) throws Exception {
        ParkingSpot parkingSpot=parkingSpotManager.allocateSpot(vehicle);
        if(parkingSpot==null){
            throw new Exception("no sport available for "+vehicle.getVehicleType());
        }
        parkingSpot.assignVehicle(vehicle);
        ParkingTicket parkingTicket=new ParkingTicket(UUID.randomUUID().toString(),vehicle,parkingSpot);
        parkingLot.addTicket(parkingTicket);
        return parkingTicket;
    }

    public double unParkVehicle(String ticketId) throws Exception {
        ParkingTicket parkingTicket=parkingLot.removeTicket(ticketId);
        if(parkingTicket==null){
            throw new Exception("Invalid Ticket");
        }
        parkingTicket.setExitTime(new Date());
        parkingSpotManager.releaseSpot(parkingTicket.getParkingSpot());

        return fareCalculationStrategy.calculateFare(parkingTicket);
    }
}
