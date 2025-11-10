public class Main {
    public static void main(String args[]){
        VendingMachine vendingMachine=new VendingMachine();
        try{
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("click on insert coin button");
            System.out.println("|");

            State vendingState=vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);


            vendingState=vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine,Coin.NICKEL);
            vendingState.insertCoin(vendingMachine,Coin.DIME);

            System.out.println("|");
            System.out.println("click on product selection");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState=vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine,102);

            displayInventory(vendingMachine);




        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemSelf[] slots=vendingMachine.getInventory().getInventory();
        for(int i=0;i<slots.length;i++){
            Item item=new Item();
            if(i>=0 && i<3){
                item.setItemType(ItemType.COKE);
                item.setPrice(12);
            }
        }
    }
    private static void displayInventory(VendingMachine vendingMachine){

    }
}
