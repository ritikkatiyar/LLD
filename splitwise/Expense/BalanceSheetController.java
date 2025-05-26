package Expense;

import Expense.Split.Split;
import User.*;

import java.util.List;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expesnsePaidBy, List<Split> splits,double totalExpenseAmount){
        //update the total amount paid of the expense paid by user
        UserExpenseBalanceSheet paidByUserExpenseSheet=expesnsePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment()+totalExpenseAmount);

        for(Split split:splits){
            User userOwe=split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet=userOwe.getUserExpenseBalanceSheet();
            double oweAmount=split.getAmountOwe();

            if(expesnsePaidBy.getUserId().equals(userOwe.getUserId())){
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount);
            }
            else{
                //update the balance of paid user
                paidByUserExpenseSheet.setTotalYourGetBack(paidByUserExpenseSheet.getTotalYourGetBack()+oweAmount);

                Balance userOweBalance;
                if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())){
                    userOweBalance=paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else{
                    userOweBalance=new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(),userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack()+oweAmount);

                //update the balance sheet of owe user
                oweUserExpenseSheet.setTotalYourOwe(oweUserExpenseSheet.getTotalYourOwe()+oweAmount);
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense()+oweAmount);

                Balance userPaidBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(expesnsePaidBy.getUserId())){
                    userPaidBalance=oweUserExpenseSheet.getUserVsBalance().get(expesnsePaidBy.getUserId());
                }
                else{
                    userPaidBalance=new Balance();

                }
            }
        }
    }
}
