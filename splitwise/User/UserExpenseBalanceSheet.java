package User;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String,Balance> userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalYourDue;
    double totalYourGetBack;

    public UserExpenseBalanceSheet(){
        userVsBalance=new HashMap<>();
        totalYourExpense=0;
        totalYourDue=0;
        totalYourGetBack=0;
    }
}
