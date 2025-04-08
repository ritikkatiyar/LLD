import java.util.HashMap;
import java.util.Map;

public class InternalButtonDispatcher {
    private final Map<Integer,ElevatorController> controllerMap=new HashMap<>();
    public void registerElevator(ElevatorController elevatorController){
        controllerMap.put(elevatorController.getId(), elevatorController);
    }
    public void handleInternalRequest(int elevatorId,int floor){
        ElevatorController elevatorController=controllerMap.get(elevatorId);
        if(elevatorController!=null){
            elevatorController.handleInternalRequest(floor);
        }
    }
}
