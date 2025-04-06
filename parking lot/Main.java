import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception {
        List<ParkingSpot> level1Spots = Arrays.asList(
                new ParkingSpot("L1-C1", ParkingSpotType.COMPACT),
                new ParkingSpot("L1-L1", ParkingSpotType.LARGE),
                new ParkingSpot("L1-E1", ParkingSpotType.ELECTRIC)
        );
        ParkingLevel level1 = new ParkingLevel(1, level1Spots);
        ParkingLot lot = new ParkingLot(List.of(level1));

        ParkingStrategy strategy = new NearestAvailableStrategy();
        ParkingSpotManager spotManager = ParkingSpotManagerFactory.create(lot.getParkingLevels(), strategy);
        FareCalculationStrategy fareStrategy = new PerHourFareStrategy(10.0, 1); // $10/hour, min 1 hour

        ParkingService service = new ParkingService(lot, spotManager, fareStrategy);

        Vehicle car = new Vehicle("ABC123", VehicleType.CAR);
        ParkingTicket ticket = service.parkVehicle(car);
        System.out.println("Vehicle parked. Ticket ID: " + ticket.getTicketId());

        Thread.sleep(2000); // Simulate parking duration

        double fare = service.unParkVehicle(ticket.getTicketId());
        System.out.println("Vehicle unparked. Fare: $" + fare);
    }
}
