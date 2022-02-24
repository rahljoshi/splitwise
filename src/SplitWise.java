import models.Group;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SplitWise {
    static Scanner scanner = new Scanner(System.in);
    /**
     * groupHashMap stores group ids as key and group as values
     * userHashMap stores user ids as key and user as values
     **/

    private static HashMap<Integer, Group> groupHashMap = new HashMap<>();
    private static HashMap<Integer, User> userHashMap = new HashMap<>();
    private static int expenseID=0;

    public static void main(String[] args) {
        User user1 = new User("ram", "r@gmail.com", 1);
        User user2 = new User("rahul", "r@gmail.com", 2);
        User user3 = new User("r", "e", 3);

        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Group group = new Group(list, 1, "lunch");
        groupHashMap.put(1, group);
        addGroupExpenses(1,10000,group,1);
        group.expensePaid(user1,0);
    }

    private static void addGroupExpenses(int groupId, int amount, Group group, int userId) {
        String description = group.getDescription();
        group.addExpenses(amount, description,userHashMap.get(userId),expenseID++);
    }
}
