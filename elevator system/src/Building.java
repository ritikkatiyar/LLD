import java.util.ArrayList;
import java.util.List;

public class Building {
    List<Floor> floorList=new ArrayList<>();
    public Building(int totalFloors, ExternalDispatcher dispatcher) {
        for(int i=1;i<=totalFloors;i++){
            floorList.add(new Floor(i,dispatcher));
        }
    }
    public Floor getFloor(int floor){
        return floorList.get(floor-1);
    }
}
