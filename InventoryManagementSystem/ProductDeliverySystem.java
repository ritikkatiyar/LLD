import java.util.List;

public class ProductDeliverySystem {
    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    ProductDeliverySystem(List<User> userList,List<Warehouse> warehouseList){
        userController=new UserController(userList);
        warehouseController=new WarehouseController(null,warehouseList);
        orderController=new OrderController();
    }
    public User getUser(int userId){
        return userController.getUser(userId);
    }
    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);
    }
    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;

    }

    public void addProductToCart(User user,ProductCategory prduct,int count){
        Cart cart=user.getUserCart();
        cart.addItemInCart(prduct.productCategoryId, count);
    }
    public Order placeOrder(User user, Warehouse warehouse){
        return orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order){
        order.checkout();
    }

}
