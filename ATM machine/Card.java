public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String holderName;
    static int PIN_NUMBER=112211;
    private UserBankAccount bankAccount;

    public boolean isCorrectPinEntered(int pin){
        if(pin==PIN_NUMBER){
            return true;
        }
        return false;
    }
    public int getBankBalance(){
        return bankAccount.balance;
    }
    public void deductBankBalance(int amount){
        bankAccount.withdrawalBalance(amount);
    }
    public void setBankAccount(UserBankAccount bankAccount){
        this.bankAccount=bankAccount;
    }
}
