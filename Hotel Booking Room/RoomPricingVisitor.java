public class RoomPricingVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoomObj) {
        System.out.println("Pricing computation logic of singleroom");
        singleRoomObj.roomPrice=1000;
    }

    @Override
    public void visit(DoubleRoom doubleRoomObj) {
        System.out.println("Pricing computation logic of DoubleRoom");
        doubleRoomObj.roomPrice=2000;
    }
}
