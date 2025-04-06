import java.util.List;

public class SimpleParkingSpotManager implements ParkingSpotManager{
    private final List<ParkingLevel> parkingLevels;
    private final ParkingStrategy parkingStrategy;

    public SimpleParkingSpotManager(List<ParkingLevel> parkingLevels, ParkingStrategy parkingStrategy) {
        this.parkingLevels = parkingLevels;
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle) {
        return parkingStrategy.findSpot(parkingLevels,vehicle);
    }

    @Override
    public void releaseSpot(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
    }
}
