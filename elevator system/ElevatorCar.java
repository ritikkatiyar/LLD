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
    public void moveTo(int floor) {
        if (floor > currentFloor) {
            currentFloor++;
            direction = Direction.UP;
        } else if (floor < currentFloor) {
            currentFloor--;
            direction = Direction.DOWN;
        }
        status = Status.MOVING;
        display.show(currentFloor, direction);

        if (currentFloor == floor) {
            status = Status.STOPPED;
            door.open();
            internalButton.clear(floor);
            door.close();
        }
    }
}
