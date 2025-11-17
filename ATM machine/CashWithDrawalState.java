public class CashWithDrawalState extends ATMState{
    public CashWithDrawalState(){
        System.out.println("Please enter the withdrawal Amount");
    }
    public void cashWithrawal(ATM atm,Card card,int withdrawalAmountRequest){
        if(atm.getBalance()<withdrawalAmountRequest){
            System.out.println("Insufficient fund in the ATM machine");
            exit(atm);
        }else if(card.getBankBalance()<withdrawalAmountRequest){
            System.out.println("Insuffient fund in your Bank Account");
            exit(atm);
        }
        else{
            card.deductBankBalance(withdrawalAmountRequest);

            //using the chain of responsibilty for the logic
            CashWithdrawalProcessor withdrawalProcessor=new TwoThousandWithrawProcessor(
                    new FiveHundredWithdrawalProcessor(new OneHundredWithdrawalProcessor(null)));
            withdrawalProcessor.withdraw(atm,withdrawalAmountRequest);
            exit(atm);

        }
    }
    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentState(new IdleState());
        System.out.println("Exit happens");
    }
    @Override
    public void returnCard(){
        System.out.println("please collect your card");
    }
}
