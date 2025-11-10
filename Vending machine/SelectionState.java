import java.util.List;

public class SelectionState implements State{
    public SelectionState(){
        System.out.println("currently vending machine is in selectionState");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you cannot click on insert coin button in this state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("you cannot insert coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        Item item=machine.getInventory().getItem(codeNumber);
        int paidByUser=0;
        for(Coin coin:machine.getCoinList()){
            paidByUser=paidByUser+coin.value;
        }
        if(paidByUser<item.getPrice()){
            System.out.println("Insufficient Amount");
            refundFullMoney(machine);
            throw new Exception("Insufficient Amount");
        }
        if(paidByUser>item.getPrice()){
            getChange(paidByUser-item.getPrice());
        }
        machine.setVendingMachineState(new DispenseState(machine,codeNumber));
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in the coin Dispense tray"+returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product cannot be dispensed in selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Retured full amount back in the coin dispense tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Invenotry cannot be updated in selection state");
    }
}
