import java.util.List;

public class Main {
    public static void main(String[] args){
        ElevatorCar car1=new ElevatorCar(1);
        //ElevatorCar car2=new ElevatorCar(2);

        ElevatorController controller1=new ElevatorController(car1);
        //ElevatorController controller2=new ElevatorController(car2);

        List<ElevatorController> elevatorControllers=List.of(controller1/*,controller2*/);

        InternalButtonDispatcher internalButtonDispatcher=new InternalButtonDispatcher();
        internalButtonDispatcher.registerElevator(controller1);
        //internalButtonDispatcher.registerElevator(controller2);

        ExternalButtonDispatcher externalButtonDispatcher=new ExternalButtonDispatcher(elevatorControllers);
        ExternalButton button1=new ExternalButton(3,Direction.UP);
        ExternalButton button2=new ExternalButton(7,Direction.DOWN);

        externalButtonDispatcher.handleExternalRequest(button1.press());
        externalButtonDispatcher.handleExternalRequest(button2.press());
        car1.pressInternalButton(5);
        internalButtonDispatcher.handleInternalRequest(1, 5);

        //car2.pressInternalButton(8);
        internalButtonDispatcher.handleInternalRequest(2, 8);

        for (int i = 0; i < 20; i++) {
            System.out.println("=== Step " + (i + 1) + " ===");
            controller1.step();
            //controller2.step();
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }
    }
}
