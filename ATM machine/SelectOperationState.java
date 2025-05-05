public class SelectOperationState extends ATMState{
    public SelectOperationState(){
        showOperationState();
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
    private void showOperationState(){

    }
}
