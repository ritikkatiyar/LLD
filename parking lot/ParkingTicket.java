import java.util.Date;

public class ParkingTicket {
    private final String ticketId;
    private final Date entryTime;
    private Date exitTime;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public ParkingTicket(String ticketId,Vehicle vehicle,ParkingSpot parkingSpot){
        this.ticketId=ticketId;
        entryTime=new Date();
        this.vehicle=vehicle;
        this.parkingSpot=parkingSpot;
    }
    public void setExitTime(Date exitTime){
        this.exitTime=exitTime;
    }
    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }
}
