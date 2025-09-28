import java.util.Date;

public class Vehicle {
    private int id;
    private VehicleType vehicleType;
    private VehicleStatus vehicleStatus;
    private String companyName;
    private String modelName;
    int kmDriven;
    Date manufacturingDate;
    int avg;
    int cc;
    int dailyRentalCost;
    int hourlyRentalCost;
    int noOfSeats;


    public Vehicle(int id,VehicleType vehicleType,VehicleStatus vehicleStatus){
        this.id=id;
        this.vehicleStatus=vehicleStatus;
        this.vehicleType=vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
