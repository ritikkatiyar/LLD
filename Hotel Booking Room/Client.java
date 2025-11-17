public class Client {
    public static void main(String args[]){
        RoomElement singleRoomObj=new SingleRoom();
        RoomElement doubleRoomObj=new DoubleRoom();

        //performing an operation on the objects
        RoomPricingVisitor pricingVisitor=new RoomPricingVisitor();
        singleRoomObj.accept(pricingVisitor);
        System.out.println(((SingleRoom)singleRoomObj).roomPrice);
    }
}
