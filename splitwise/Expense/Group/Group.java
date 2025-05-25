package Expense.Group;
import User.User;
import Expense.*;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;

    Group(){
        groupMembers=new ArrayList<>();
        expenseList=new ArrayList<>();
        expenseController=new ExpenseController();
    }
    //add member to the group
    public void addMember(User member){
        groupMembers.add(member);
    }
    public String getGroupId(){
        return groupId;
    }
    public void setGroupId(String groupId){
        this.groupId=groupId;
    }

}
