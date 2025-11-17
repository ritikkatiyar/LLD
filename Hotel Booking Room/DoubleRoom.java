public class DoubleRoom implements RoomElement{
    public int room0Price=0;
    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}
