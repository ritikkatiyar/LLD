import java.util.Set;
import java.util.TreeSet;

public class InternalButton {
    private final Set<Integer> selectedFloors=new TreeSet<>();

    public void press(int floor){
        selectedFloors.add(floor);
        System.out.println("Internal button pressed for floor "+floor);
    }
    public Set<Integer> getSelectedFloors(){
        return selectedFloors;
    }
    public void clear(int floor){
        selectedFloors.remove(floor);
    }
}
