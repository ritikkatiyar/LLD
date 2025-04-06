import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final List<ParkingLevel> parkingLevels;
    private final Map<String,ParkingTicket> activeTickets;

    public ParkingLot(List<ParkingLevel> parkingLevels){
        this.parkingLevels=parkingLevels;
        this.activeTickets=new HashMap<>();
    }
    public List<ParkingLevel> getParkingLevels(){
        return parkingLevels;
    }
    public void addTicket(ParkingTicket parkingTicket){
        activeTickets.put(parkingTicket.getTicketId(), parkingTicket);
    }
    public ParkingTicket removeTicket(String ticketId){
        return activeTickets.remove(ticketId);
    }
}
