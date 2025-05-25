package Expense.Group;

import User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    public GroupController(){
        groupList=new ArrayList<>();
    }
    //create group
    public void createNewGroup(String groupId, String groupName, User createdByUser){
        //create a new group
        Group group=new Group();
        group.setGroupId(groupId);
        group.groupName=groupName;

        //add user into the group,as it is created by the user
        group.addMember(createdByUser);
        groupList.add(group);
    }
}
