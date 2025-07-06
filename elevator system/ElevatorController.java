import java.util.PriorityQueue;
import java.util.TreeSet;

public class ElevatorController {
    PriorityQueue<Integer> upminPq;
    PriorityQueue<Integer> downMaxPq;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar=elevatorCar;
        upminPq=new PriorityQueue<>();
        downMaxPq=new PriorityQueue<>((a,b)->b-a);
    }

    public void submitExternalRequest(int floorNumber, Direction direction) {
        if(direction==Direction.DOWN){
            downMaxPq.offer(floorNumber);
        }else{
            upminPq.offer(floorNumber);
        }
    }
    public void submitInternalRequest(int floor){

    }
    public void controlElevator(){
        while(true){
            if(elevatorCar.elevatorDirection==Direction.UP){

            }
        }
    }
}

