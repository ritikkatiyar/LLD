public class ATMRoom {
    ATM atm;
    User user;
    public static void main(String args[]){
        ATMRoom atmRoom=new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentState().insertCard(atmRoom.atm,atmRoom.user.card);
        atmRoom.atm.getCurrentState().authenticatePin(atmRoom.atm,atmRoom.user.card,112211);
        atmRoom.atm.getCurrentState().selectOperation(atmRoom.atm,atmRoom.user.card,TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentState().cashWithdrawal(atmRoom.atm,atmRoom.user.card,2700);
        atmRoom.atm.printCurrentATMStatus();

    }
    public void initialize(){
        //create ATM
        atm=ATM.getAtmObject();
        atm.setBalance(3500,1,2,5);

        //create user
        this.user=createUser();
    }

    private User createUser() {
        User user=new User();
        user.setCard(createCard());
        return null;
    }

    private Card createCard() {
        Card card=new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {
        UserBankAccount bankAccount=new UserBankAccount();
        bankAccount.balance=3000;
        return bankAccount;
    }

}
