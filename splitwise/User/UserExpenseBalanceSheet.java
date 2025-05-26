package User;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String,Balance> userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalYourOwe;
    double totalYourGetBack;

    public UserExpenseBalanceSheet(){
        userVsBalance=new HashMap<>();
        totalYourExpense=0;
        totalYourOwe=0;
        totalYourGetBack=0;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalYourOwe() {
        return totalYourOwe;
    }

    public void setTotalYourOwe(double totalYourOwe) {
        this.totalYourOwe = totalYourOwe;
    }

    public double getTotalYourGetBack() {
        return totalYourGetBack;
    }

    public void setTotalYourGetBack(double totalYourGetBack) {
        this.totalYourGetBack = totalYourGetBack;
    }
}
