public class ElevatorCar {
    int id;
    int currentFloor;
    int nextFloorStoppage;
    public ElevatorDirection movingDirection;
    Door door;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.movingDirection = ElevatorDirection.IDLE;
        this.door = new Door();
    }
    public void showDisplay(){
        System.out.println("elevator : "+id+"current floor "+currentFloor+"going" +movingDirection);
    }
    public void moveElevator(int destinationFloor){
        //this is dumb object so if the command has come to go particular direction it just move to
        this.nextFloorStoppage=destinationFloor;
        if(this.currentFloor==destinationFloor){
            door.openDoor(id);
            return;
        }
        int startFloor=this.currentFloor;

        if(nextFloorStoppage>=currentFloor){
            movingDirection=ElevatorDirection.UP;
            showDisplay();
            for(int i=startFloor+1;i<nextFloorStoppage;i++){
                try{
                    Thread.sleep(5);
                }catch (Exception e){

                }
                setCurrentFloor(i);
                showDisplay();
            }
        }else{
            movingDirection=ElevatorDirection.DOWN;
            showDisplay();
            for(int i=startFloor+1;i>=nextFloorStoppage;i--){
                try{
                    Thread.sleep(5);
                }catch (Exception e){

                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        door.openDoor(id);
    }
    public void setCurrentFloor(int currentFloor){
        this.currentFloor=currentFloor;
    }
}
