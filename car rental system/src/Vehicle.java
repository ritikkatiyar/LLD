public class Vehicle {
    private final int vehicleId;
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private double dailyRentCost;
    private volatile VehicleStatus vehicleStatus;

    public Vehicle(int vehicleId, String vehicleNumber, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public double getDailyRentCost() {
        return dailyRentCost;
    }

    public void setDailyRentCost(double dailyRentCost) {
        this.dailyRentCost = dailyRentCost;
    }

    public int getVehicleId() {
        return vehicleId;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
