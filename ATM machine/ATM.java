public class ATM {
    private static ATM atmObject=new ATM();
    ATMState currentState;
    private int balance;
    int noOfTwoThousandNotes;
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

    public void setBalance(int balance,int noOfTwoThousandNotes,int noOfFiveHundredNotes,int noOfOneHundredNotes) {
        this.balance = balance;
        this.noOfTwoThousandNotes=noOfTwoThousandNotes;
        this.noOfFiveHundredNotes=noOfFiveHundredNotes;
        this.noOfOneHundredNotes=noOfOneHundredNotes;
    }

    public void printCurrentATMStatus() {
        System.out.println(currentState+" balance "+balance);
    }
    public void deductTwoThousandNotes(int notes){
        noOfTwoThousandNotes=noOfTwoThousandNotes-notes;
    }
    public void deductFiveHundredNotes(int notes){
        noOfFiveHundredNotes=noOfFiveHundredNotes-notes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }
}
