import java.util.List;

public class NearestStrategy implements ElevatorSelectionStrategy{
    @Override
    public ElevatorController selectElevator(List<ElevatorController> elevatorControllers, int requestFloor,
                                             ElevatorDirection direction) {

        ElevatorController bestController=null;
        int minDistance=Integer.MAX_VALUE;

        for(ElevatorController controller:elevatorControllers){
            int nextFloorStoppage=controller.elevatorCar.nextFloorStoppage;

            boolean isSameDirectionCandidate=controller.elevatorCar.movingDirection ==direction
                    && ((direction==ElevatorDirection.UP && nextFloorStoppage<=requestFloor) ||
                    (direction==ElevatorDirection.DOWN && nextFloorStoppage>=requestFloor));

            int dist=Math.abs(nextFloorStoppage-requestFloor);
            if(isSameDirectionCandidate &&dist<minDistance){
                minDistance=dist;
                bestController=controller;
            }
        }
        if(bestController==null){
            for(ElevatorController controller:elevatorControllers){
                if(controller.elevatorCar.movingDirection==ElevatorDirection.IDLE){
                    bestController=controller;
                    break;
                }
            }
        }
        if(bestController==null){
            bestController=elevatorControllers.get(0);
        }
        return bestController;
    }
}
