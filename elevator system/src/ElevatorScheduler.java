import java.util.List;

public class ElevatorScheduler {
    private final List<ElevatorController> elevatorControllerList;
    private ElevatorSelectionStrategy selectionStrategy;

    public ElevatorScheduler(List<ElevatorController> elevatorControllerList,ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.elevatorControllerList = elevatorControllerList;
        this.selectionStrategy=elevatorSelectionStrategy;
    }
    public void setSelectionStrategy(ElevatorSelectionStrategy selectionStrategy){
        this.selectionStrategy=selectionStrategy;
    }
    public ElevatorController assignElevator(int floor,ElevatorDirection direction){
        ElevatorController controller=selectionStrategy.selectElevator(elevatorControllerList,floor,direction);
        return controller;
    }
}
