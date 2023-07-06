package org.hw13;

import org.hw13.User;
import org.hw13.UserUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Smith", 25));
        users.add(new User("Emily", "Davis", 20));
        users.add(new User("Michael", "Johnson", 35));
        users.add(new User("Sophia", "Williams", 30));
        users.add(new User("Daniel", "Brown", 18));
        users.add(new User("Olivia", "Miller", 22));
        users.add(new User("James", "Taylor", 28));
        users.add(new User("Emma", "Anderson", 40));
        users.add(new User("Alexander", "Jones", 19));
        users.add(new User("Isabella", "Wilson", 32));

        UserUtils.sortUsersByAge(users);
        UserUtils.calculateAverageAge(users);
        UserUtils.sortUsersByMultipleProperties(users);
        UserUtils.checkUsersWithSpecificLastName(users);
        UserUtils.checkIfAllUsersOver18(users);
    }
}
