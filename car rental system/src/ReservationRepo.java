import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepo {
    //reservationId->Reservation
    private final Map<Integer,Reservation> reservationMap;

    public ReservationRepo(){
        this.reservationMap=new ConcurrentHashMap<>();
    }
    //save or update Reservation
    public void save(Reservation reservation){
        reservationMap.put(reservation.getReservationId(),reservation);
    }
    //lookup reservation by id
    public Optional<Reservation> findById(int reservationId){
        return Optional.ofNullable(reservationMap.get(reservationId));
    }
    //delete reservation from repo
    public void remove(int reservationId){
        reservationMap.remove(reservationId);
    }
    //return all reservations (for reporting/debug)
    public Map<Integer,Reservation> getAll(){
        return reservationMap;
    }
}
