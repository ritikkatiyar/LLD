import java.util.List;

public class ExternalDispatcher {
    private final List<ElevatorController> elevatorControllers=ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floorNumber, Direction direction) {
        //for simplicity odd-even rule is followed
        for(ElevatorController controller:elevatorControllers){
            int elevatorId=controller.elevatorCar.id;
            if(elevatorId%2==1 && floorNumber%2==1){
                controller.submitExternalRequest(floorNumber,direction);
            }else if(elevatorId%2==0 && floorNumber%2==0){
                controller.submitExternalRequest(floorNumber,direction);
            }
        }
    }
}
