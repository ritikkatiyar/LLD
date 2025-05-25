package Expense;

import Expense.Split.Split;

import java.util.List;

public interface ExpenseSplit {
    public void validateSplitRequest(List<Split> splitList,double totalAmount);
}
