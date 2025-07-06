public class ElevatorCar {

    int id;
    Display display;
    InternalButton internalButtons;
    Status elevatorState;
    int currentFloor;
    Direction elevatorDirection;
    Door elevatorDoor;

    public ElevatorCar(){
        display = new Display();
        internalButtons = new InternalButton();
        elevatorState = Status.IDLE;
        currentFloor = 0;
        elevatorDirection = Direction.UP;
        elevatorDoor = new Door();

    }
    public void showDisplay() {
        display.showDisplay();
    }

    public void pressButton(int destination) {
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay() {
        this.display.setDisplay(currentFloor, elevatorDirection);
    }

    boolean moveElevator(Direction dir, int destinationFloor){
        int startFloor = currentFloor;
        if(dir == Direction.UP) {
            for(int i = startFloor; i<=destinationFloor; i++) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }

        if(dir == Direction.DOWN) {
            for(int i = startFloor; i>=destinationFloor; i--) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }
        return false;
    }

}
