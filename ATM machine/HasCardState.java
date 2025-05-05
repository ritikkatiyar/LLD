public class HasCardState extends ATMState{
    public HasCardState(){
        System.out.println("enter your card pin number");
    }
    @Override
    public void authenticatePin(ATM atm,Card card,int pin){
        boolean isCurrectPinEntered=card.isCorrectPinEntered(pin);

        if(isCurrectPinEntered){
            atm.setCurrentState(new SelectOperationState());
        }else{
            System.out.println("Invalid PIN number");
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
