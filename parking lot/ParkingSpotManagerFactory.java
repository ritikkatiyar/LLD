import java.util.List;

public class ParkingSpotManagerFactory {
    public static ParkingSpotManager create(List<ParkingLevel> parkingLevels,ParkingStrategy parkingStrategy){
        return new SimpleParkingSpotManager(parkingLevels,parkingStrategy);
    }
}
