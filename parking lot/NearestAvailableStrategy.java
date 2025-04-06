import java.util.List;

public class NearestAvailableStrategy implements  ParkingStrategy{

    @Override
    public ParkingSpot findSpot(List<ParkingLevel> parkingLevels, Vehicle vehicle) {
        for(ParkingLevel parkingLevel:parkingLevels){
            for(ParkingSpot parkingSpot:parkingLevel.getParkingSpotList()){
                if(parkingSpot.isAvailable() && parkingSpot.canFitVehicle(vehicle)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
