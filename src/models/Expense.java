package models;

import java.util.List;

public class Expense {
    private int id;
    private String description;
    private final int amount;
    private final List<User> users;
    private final Currency currencyType;
    private final User paidBy;

    public Expense(int id, String description, int amount, List<User> users, Currency currencyType, User paidBy) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.users = users;
        this.currencyType = currencyType;
        this.paidBy = paidBy;
    }

    public int splitBill(){
        int bill = amount / users.size();
        for(int i=0;i< users.size();i++){
            paidBy.addAmount(bill,users.get(i));
            users.get(i).addAmount(bill, paidBy);
        }
        return bill;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public List<User> getUsers() {
        return users;
    }

    public Currency getCurrencyType() {
        return currencyType;
    }

}
