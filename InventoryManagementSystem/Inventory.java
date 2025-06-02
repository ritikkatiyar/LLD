import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<ProductCategory> productCategoryList;
    Inventory(){
        productCategoryList=new ArrayList<>();
    }
    public void addCategory(int categoryId,String name,int price){
        ProductCategory productCategory=new ProductCategory();
        productCategory.price=price;
        productCategory.categoryName=name;
        productCategory.productCategoryId=categoryId;
        productCategoryList.add(productCategory);
    }
    public void addProduct(Product product,int productCategoryId){
        ProductCategory productCategory=null;
        for(ProductCategory productCategory1:productCategoryList){
            if(productCategory1.productCategoryId==productCategoryId){
                productCategory=productCategory1;
            }
        }
        if(productCategory!=null){
            productCategory.addProduct(product);
        }
    }
    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap) {
        productCategoryAndCountMap.forEach((categoryId, count) -> {
            ProductCategory category = getProductCategoryFromId(categoryId);
            category.removeProduct(count);
        });
    }

    private ProductCategory getProductCategoryFromId(int productCategoryId){
        for(ProductCategory productCategory:productCategoryList){
            if(productCategory.productCategoryId==productCategoryId){
                return productCategory;
            }
        }
        return null;
    }

}
