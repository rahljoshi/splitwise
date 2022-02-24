package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User extends Account{
    int id;
    int totalOwns;

    //map will tell with whom the user owns the money
    Map<User, Integer> userVsAmount= new HashMap<>();
    List<Group> listOfGroup;

    public User(String name, String email, int id){
        this.name = name;
        this.email = email;
        this.totalOwns = 0;
        this.id = id;
        listOfGroup = new ArrayList<Group>();
    }
    public void addAmount(int amount, User user){
        totalOwns += amount;
        //if user own previously money to a user then money will added to the previous one
        userVsAmount.put(user, userVsAmount.getOrDefault(user, 0)+amount);
    }

}
