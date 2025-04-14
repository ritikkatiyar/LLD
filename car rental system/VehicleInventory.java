import java.util.HashMap;
import java.util.Map;

public class VehicleInventory {
    private Map<Integer,Vehicle> vehicleMap;

    public VehicleInventory(){
        this.vehicleMap=new HashMap<>();
    }
    public void addVehicle(Vehicle vehicle){
        vehicleMap.put(vehicle.getId(),vehicle);
    }
    public Vehicle getVehicle(int vehicleId){
        return vehicleMap.get(vehicleId);
    }
    public void updateVehicleStatus(int vehicleId,VehicleStatus vehicleStatus){
        Vehicle vehicle=vehicleMap.get(vehicleId);
        if(vehicle!=null){
            vehicle.setVehicleStatus(vehicleStatus);
        }
    }
    public void removeVehicle(int vehicleId){
        vehicleMap.remove(vehicleId);
    }
    public Map<Integer,Vehicle> getAllVehiceles(){
        return vehicleMap;
    }
}
