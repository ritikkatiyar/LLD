import java.util.List;

public class LeastBusyStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorController selectElevator(List<ElevatorController> elevatorControllers, int requestFloor,
                                             ElevatorDirection direction) {
        ElevatorController best=null;
        int minLoad=Integer.MAX_VALUE;
        for(ElevatorController controller:elevatorControllers){
            int load=controller.upMinPQ.size()+controller.downMaxPQ.size();

            if(load<minLoad){
                minLoad=load;
                best=controller;
            }
        }
        return best;
    }
}
