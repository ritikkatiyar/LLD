public class SelectOperationState extends ATMState{
    public SelectOperationState(){
        showOperations();
    }
    @Override
    public void selectOperation(ATM atm,Card card,TransactionType transactionType){
        switch (transactionType){
            case CASH_WITHDRAWAL :
                atm.setCurrentState(new CashWithDrawalState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentState(new CheckBalanceState());
                break;
            default:{
                System.out.println("Invalid Option");
                exit(atm);
            }
        }
    }
    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentState(new IdleState());
        System.out.println("Exit Happens");
    }
    @Override
    public void returnCard(){
        System.out.println("Please select your card");
    }
    private void showOperations(){
        System.out.println("please select the operation");
        TransactionType.showAllTransactionsTypes();
    }
}
