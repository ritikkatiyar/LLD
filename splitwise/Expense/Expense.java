package Expense;

import Expense.Split.Split;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails=new ArrayList<>();

    public Expense(String expenseId,double expenseAmount,String description,
                   User paidByUser,ExpenseSplitType splitType,List<Split> splitDetails){
        this.expenseId=expenseId;
        this.description=description;
        this.expenseAmount=expenseAmount;
        this.paidByUser=paidByUser;
        this.splitType=splitType;
        this.splitDetails=splitDetails;
    }
}
