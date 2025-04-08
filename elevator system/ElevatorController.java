import java.util.TreeSet;

public class ElevatorController {
    final ElevatorCar elevatorCar;
    final TreeSet<Integer> requests = new TreeSet<>();

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public int getId() {
        return elevatorCar.id;
    }

    public void handleInternalRequest(int floor) {
        requests.add(floor);
    }

    public void step() {
        if (requests.isEmpty()) {
            elevatorCar.direction = Direction.IDLE;
            elevatorCar.status = Status.IDLE;
            elevatorCar.display.show(elevatorCar.currentFloor, elevatorCar.direction);
        }
        Integer next = getNextFloorLOOK();
        if (next != null) {
            elevatorCar.moveTo(next);
            if (elevatorCar.currentFloor == next) {
                requests.remove(next);
            }
        }
    }

    private Integer getNextFloorLOOK() {
        if (elevatorCar.direction == Direction.UP || elevatorCar.direction == Direction.IDLE) {
            for (Integer floor : requests) {
                if (floor >= elevatorCar.currentFloor) {
                    elevatorCar.direction = Direction.UP;
                    return floor;
                }
            }
            for (Integer floor : requests.descendingSet()) {
                if (floor < elevatorCar.currentFloor) {
                    elevatorCar.direction = Direction.DOWN;
                    return floor;
                }
            }
        } else {
            for (Integer floor : requests.descendingSet()) {
                if (floor <= elevatorCar.currentFloor) {
                    elevatorCar.direction = Direction.DOWN;
                    return floor;
                }
            }
            for (Integer floor : requests) {
                if (floor > elevatorCar.currentFloor) {
                    elevatorCar.direction = Direction.UP;
                    return floor;
                }
            }
        }
        return null;
    }
}

