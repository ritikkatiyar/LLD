public class ExternalButton {
    private final int floor;
    private final Direction direction;

    public ExternalButton(int floor,Direction direction){
        this.floor=floor;
        this.direction=direction;
    }
    public ExternalRequest press(){
        System.out.println("External button pressed at floor "+floor+" going "+direction);
        return new ExternalRequest(floor,direction);
    }
}
