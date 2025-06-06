import java.util.List;

public class HasMoneyState implements State{
    public HasMoneyState(){
        System.out.println("currently vending machine is in hasMoneyState");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you need to click on start product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product cannot be dispanced in hasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        return List.of();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {

    }
}
