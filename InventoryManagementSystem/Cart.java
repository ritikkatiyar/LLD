import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer,Integer> productCategoryVsCountMap;
    Cart(){
        productCategoryVsCountMap=new HashMap<>();
    }
    public void addItemInCart(int productCategoryId,int count){
        if(productCategoryVsCountMap.containsKey(productCategoryId)){
            int noOfItemsInCart=productCategoryVsCountMap.get(productCategoryId);
            productCategoryVsCountMap.put(productCategoryId,noOfItemsInCart+count);
        }else {
            productCategoryVsCountMap.put(productCategoryId,count);
        }
    }
    public void removeItemFromCart(int productCategoryId,int count){
        if(productCategoryVsCountMap.containsKey(productCategoryId)){
            int noOfItemsInCrt=productCategoryVsCountMap.get(productCategoryId);
            if(count-noOfItemsInCrt==0){
                productCategoryVsCountMap.remove(productCategoryId);
            }else{
                productCategoryVsCountMap.put(productCategoryId, noOfItemsInCrt - count);
            }
        }
    }
    public void emptyCart(){
        productCategoryVsCountMap = new HashMap<>();
    }

    //View Cart
    public  Map<Integer, Integer> getCartItems(){

        return productCategoryVsCountMap;
    }

}
