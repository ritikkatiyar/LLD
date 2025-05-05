public class ATM {
    private static ATM atmObject=new ATM();
    ATMState currentState;
    private int balance;
    int noOfThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    public ATM(){

    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }
    public static ATM getAtmObject(){
        atmObject.setCurrentState(new IdleState());
        return atmObject;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance,int noOfThousandNotes,int noOfFiveHundredNotes,int noOfOneHundredNotes) {
        this.balance = balance;
        this.noOfThousandNotes=noOfThousandNotes;
        this.noOfFiveHundredNotes=noOfFiveHundredNotes;
        this.noOfOneHundredNotes=noOfOneHundredNotes;
    }

    public void printCurrentATMStatus() {
        currentState=new IdleState();
    }
}
