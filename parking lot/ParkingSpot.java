public class ParkingSpot {
    private final String id;
    private final ParkingSpotType parkingSpotType;
    private boolean isOccupied;
    Vehicle vehicle;

    public ParkingSpot(String id,ParkingSpotType parkingSpotType){
        this.id=id;
        this.parkingSpotType=parkingSpotType;
    }
    public boolean isAvailable(){
        return !isOccupied;
    }
    public boolean canFitVehicle(Vehicle vehicle){
        switch(vehicle.getVehicleType()){
            case ELECTRIC_CAR: return true;
            case CAR: return parkingSpotType != ParkingSpotType.ELECTRIC;
            case MOTORCYCLE: return parkingSpotType == ParkingSpotType.COMPACT;
            case TRUCK: return parkingSpotType == ParkingSpotType.LARGE;
            default: return false;
        }
    }
    public void assignVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isOccupied=true;
    }
    public void removeVehicle(){
        this.vehicle=null;
        this.isOccupied=false;
    }
    public String getId(){
        return id;
    }
}
