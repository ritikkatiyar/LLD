public class Floor {
    final int floorNumber;
    ExternalButton upButton;
    ExternalButton downButton;
    public Floor(int floorNumber,ExternalDispatcher dispatcher){
        this.floorNumber=floorNumber;
        this.upButton=new ExternalButton(dispatcher);
        this.downButton=new ExternalButton(dispatcher);
    }
    public void pressUpBotton(){
        upButton.pressButton(floorNumber,ElevatorDirection.UP);
    }
    public void pressDownBotton(){
        upButton.pressButton(floorNumber,ElevatorDirection.DOWN);
    }
}
