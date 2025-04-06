import java.util.List;

public class ParkingLevel {
    private final int levelNumber;
    private final List<ParkingSpot> parkingSpotList;

    public ParkingLevel(int levelNumber,List<ParkingSpot> parkingSpotList){
        this.levelNumber=levelNumber;
        this.parkingSpotList=parkingSpotList;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }
}
