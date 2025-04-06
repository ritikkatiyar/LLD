import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class PerHourFareStrategy implements FareCalculationStrategy{

    private final double ratePerHour;
    private final int minHours;
    public PerHourFareStrategy(double ratePerHour,int minHours){
        this.ratePerHour=ratePerHour;
        this.minHours=minHours;
    }
    @Override
    public double calculateFare(ParkingTicket parkingTicket) {
        long durationMillis=parkingTicket.getExitTime().getTime()-parkingTicket.getEntryTime().getTime();
        long durationHours= TimeUnit.MICROSECONDS.toHours(durationMillis);
        long chargedHours=Math.max(durationHours,minHours);
        return chargedHours*ratePerHour;
    }
}
