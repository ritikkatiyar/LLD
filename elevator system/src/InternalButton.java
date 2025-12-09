public class InternalButton {
    ElevatorController controller;
    public InternalButton(ElevatorController elevatorController){
        this.controller=elevatorController;
    }
    public void pressButton(int floor){
        controller.submitRequest(floor);
    }
}
