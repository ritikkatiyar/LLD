import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> elevatorControllers,
                                      int requestFloor,ElevatorDirection direction);
}
