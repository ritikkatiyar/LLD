import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            //create elevator cars and their controllers
            ElevatorCar car1=new ElevatorCar(1);
            ElevatorController controller1=new ElevatorController(car1);

            ElevatorCar car2=new ElevatorCar(2);
            ElevatorController controller2=new ElevatorController(car2);

            //create one internal button for each elevator
            InternalButton internalButton1=new InternalButton(controller1);
            InternalButton internalButton2=new InternalButton(controller2);

            //create scheduler with neraset stragy
            ElevatorScheduler scheduler=new ElevatorScheduler(Arrays.asList(controller1,controller2),new NearestStrategy());

            //create external dispactcher
            ExternalDispatcher dispatcher=new ExternalDispatcher(scheduler);

            //create a 5 floor building
            Building building=new Building(5,dispatcher);

            new Thread(controller1,"Elevator-1").start();
            new Thread(controller2,"Elevator-2").start();

            //lets submit the request
            //external call :floor 3 up
            //external call :floor 5 down
            //internal call :elevator 1(press 4)
            //internal call :elevator 2(press 5)
            //external call :floor 1 down
            //external call :floor 2 up

            building.getFloor(3).pressUpBotton();
            Thread.sleep(5000);


            building.getFloor(5).pressDownBotton();
            Thread.sleep(5000);

            internalButton1.pressButton(4);
            Thread.sleep(5000);

            internalButton2.pressButton(5);
            Thread.sleep(5000);

            building.getFloor(1).pressDownBotton();
            Thread.sleep(5000);

            building.getFloor(2).pressUpBotton();
            Thread.sleep(5000);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}