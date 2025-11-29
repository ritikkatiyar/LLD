public class Client {
    public static void main(String args[]){
        RoomElement singleRoomObj=new SingleRoom();
        RoomElement doubleRoomObj=new DoubleRoom();

        //performing an operation on the objects
        RoomPricingVisitor pricingVisitor=new RoomPricingVisitor();
        singleRoomObj.accept(pricingVisitor);
        System.out.println(((SingleRoom)singleRoomObj).roomPrice);

        doubleRoomObj.accept(pricingVisitor);
        System.out.println(((DoubleRoom)doubleRoomObj).roomPrice);

        //performing another operation on the objects
        RoomMaintenanceVisitor maintenanceVisitor=new RoomMaintenanceVisitor();
        singleRoomObj.accept(maintenanceVisitor);
    }
}
