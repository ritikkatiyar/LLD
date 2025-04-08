import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ElevatorCar {
    int id;
    int currentFloor;
    Direction direction;
    Status status;
    InternalButton internalButton;
    Display display;
    Door door;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor=0;
        this.direction=Direction.IDLE;
        this.status=Status.IDLE;
        this.internalButton=new InternalButton();
        this.display=new Display();
        this.door=new Door();
    }
    public void pressInternalButton(int floor){
        internalButton.press(floor);
    }
    public void move(){
        Integer nextFloor=getNextDestination();
        if(nextFloor==null){
            status=Status.IDLE;
            direction=Direction.IDLE;
            display.show(currentFloor,direction);
            return;
        }
        if(nextFloor>currentFloor){
            currentFloor++;
            direction=Direction.UP;
        }else if(nextFloor<currentFloor){
            currentFloor--;
            direction=Direction.DOWN;
        }
        status=Status.MOVING;
        display.show(currentFloor,direction);

        if(currentFloor==nextFloor){
            status=Status.STOPPED;
            door.open();
            internalButton.clear(currentFloor);
            door.close();
        }
    }
    private Integer getNextDestination(){
        Set<Integer> requests=internalButton.getSelectedFloors();
        if(requests.isEmpty()) return null;

        List<Integer> up=requests.stream().filter(f->f>currentFloor).sorted().toList();
        List<Integer> down=requests.stream().filter(f->f<currentFloor).sorted(Comparator.reverseOrder())
                .toList();

        if(direction==Direction.UP){
            if(!up.isEmpty()) return up.get(0);
            else if (!down.isEmpty()){
                direction=Direction.DOWN;
                return down.get(0);
            }
        }else if(direction == Direction.DOWN){
            if(!down.isEmpty()) return down.get(0);
            else if(!up.isEmpty()){
                direction=Direction.UP;
                return up.get(0);
            }
        }else{
            if(!up.isEmpty()){
                direction=Direction.UP;
                return up.get(0);
            }else if(!down.isEmpty()){
                direction=Direction.DOWN;
                return down.get(0);
            }
        }
        return null;
    }
}
