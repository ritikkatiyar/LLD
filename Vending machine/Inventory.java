public class Inventory {
    ItemSelf[] itemSelves=null;
    Inventory(int itemCount){
        itemSelves=new ItemSelf[itemCount];
        initialEmptyInventory();
    }
    public ItemSelf[] getInventory(){
        return itemSelves;
    }
    public void setInventory(ItemSelf[] itemSelves){
        this.itemSelves=itemSelves;
    }
    public void initialEmptyInventory(){
        int startCode=10;
        for(int i=0;i<itemSelves.length;i++){
            ItemSelf space=new ItemSelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            itemSelves[i]=space;
            startCode++;
        }
    }
    public void addItem(Item item,int codeNumber) throws Exception{
        for(ItemSelf itemSelf:itemSelves){
            if(itemSelf.getCode()==codeNumber){
                if(itemSelf.isSoldOut()){
                    itemSelf.setItem(item);
                    itemSelf.setSoldOut(false);
                }else{
                    throw new Exception("already item is present ,you can not add item here");
                }
            }
        }
    }

    public void updateSoldOutItem(int codeNumber) {
    }

    public Item getItem(int codeNumber) {
        return new Item();
    }
}
