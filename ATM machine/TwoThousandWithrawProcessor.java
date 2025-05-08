public class TwoThousandWithrawProcessor extends CashWithdrawalProcessor{
    public TwoThousandWithrawProcessor(CashWithdrawalProcessor nexWithdrawalProcessor){
        super(nexWithdrawalProcessor);
    }
    public void withdraw(ATM atm,int remainingAmt){
        int required=remainingAmt/2000;
        int balance=remainingAmt%2000;

        if(required<=atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(required);
        }else if(required>atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance=balance-(required-atm.getNoOfTwoThousandNotes())*2000;
        }
        if(balance!=0){
            super.withdraw(atm,balance);
        }
    }
}
