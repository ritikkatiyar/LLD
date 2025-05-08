public abstract class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    CashWithdrawalProcessor(CashWithdrawalProcessor withdrawalProcessor){
        this.nextCashWithdrawalProcessor=withdrawalProcessor;
    }
    public void withdraw(ATM atm,int remainingAmt){
        if(nextCashWithdrawalProcessor!=null){
            nextCashWithdrawalProcessor.withdraw(atm,remainingAmt);
        }
    }
}
