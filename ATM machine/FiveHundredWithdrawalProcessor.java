public class FiveHundredWithdrawalProcessor extends CashWithdrawalProcessor{
    public FiveHundredWithdrawalProcessor(CashWithdrawalProcessor nexWithdrawalProcessor){
        super(nexWithdrawalProcessor);
    }
    public void withdraw(ATM atm,int remainingAmt){
        int required=remainingAmt/2000;
        int balance=remainingAmt%2000;

        if(required<=atm.getNoOfTwoThousandNotes()){
            atm.deductFiveHundredNotes(required);
        }else if(required>atm.getNoOfTwoThousandNotes()){
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance=balance-(required-atm.getNoOfFiveHundredNotes())*2000;
        }
        if(balance!=0){
            super.withdraw(atm,balance);
        }
    }
}
