import java.util.List;

public class ExternalButtonDispatcher {
    private final List<ElevatorController> elevatorControllers;
    public ExternalButtonDispatcher(List<ElevatorController> elevatorControllers){
        this.elevatorControllers=elevatorControllers;
    }
    public void handleExternalRequest(ExternalRequest externalRequest){
        ElevatorController best=null;
        int minDistance=Integer.MAX_VALUE;

        for(ElevatorController elevatorController:elevatorControllers){
            ElevatorCar elevatorCar=elevatorController.elevatorCar;
            int distance=Math.abs(elevatorCar.currentFloor-externalRequest.floor);

            if(distance<minDistance &&
                    (elevatorCar.direction ==Direction.IDLE || elevatorCar.direction ==externalRequest.direction)){
                minDistance=distance;
                best=elevatorController;
            }
        }
        if(best!=null){
            System.out.println("Dispatcher elevator "+best.getId()+" to floor "+externalRequest.floor);
            best.handleInternalRequest(externalRequest.floor);
        }
        else {
            System.out.println("No suitable elevator found for floor " + externalRequest.floor);
        }
    }
}
