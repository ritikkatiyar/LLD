public interface ParkingSpotManager {
    ParkingSpot allocateSpot(Vehicle vehicle);
    void releaseSpot(ParkingSpot parkingSpot);
}
