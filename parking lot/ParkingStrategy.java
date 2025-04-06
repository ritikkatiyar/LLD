import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingLevel> parkingLevels,Vehicle vehicle);
}
