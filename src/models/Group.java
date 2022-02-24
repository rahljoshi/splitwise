package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    private List<User> users;
    private int id;
    private String description;
    private Map<Integer, Expense> expIdVsExp = new HashMap<>();
    int equalSplit;
    public Group(List<User> group, int id, String description){
        this.users = group;
        this.description = description;
        this.id = id;
    }

    public int getGroupId(){
        return this.id;
    }
    public String getDescription(){
        return this.description;
    }

    public List<User> listOfUsers() {
        return this.users;
    }

    public void addExpenses(int amount, String des, User paidBy, int expenseId){
        List<User> expUser = new ArrayList<>(users);
        expUser.remove(paidBy);
        Expense expense = new Expense(expenseId, des, amount, expUser,Currency.RUPEE,paidBy);
        expense.splitBill();
        expIdVsExp.put(expenseId, expense);

    }
    public void expensePaid(int amount,User paidBy, int expenseID){
        paidBy.totalOwns -= amount;
    }

}
