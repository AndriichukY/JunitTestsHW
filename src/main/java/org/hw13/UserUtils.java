package org.hw13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserUtils {
    public static List<User> sortUsersByAge(List<User> users) {
        List<User> sortedByAge = new ArrayList<>(users);
        sortedByAge.sort(Comparator.comparingInt(User::getAge));
        System.out.println("Sorted by age:");
        sortedByAge.forEach(System.out::println);
        return sortedByAge;
    }

    public static double calculateAverageAge(List<User> users) {
        double averageAge = users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
        System.out.println("Average age of users: " + averageAge);
        return averageAge;
    }

    public static List<User> sortUsersByMultipleProperties(List<User> users) {
        users.sort(Comparator
                .comparing(User::getFirstName)
                .thenComparingInt(User::getAge));
        System.out.println("Sorted by firstName and age:");
        users.forEach(System.out::println);
        return users;
    }

    public static boolean checkUsersWithSpecificLastName(List<User> users) {
        boolean hasUsersWithSA = users.stream()
                .anyMatch(user -> user.getLastName().startsWith("S") || user.getLastName().startsWith("A"));
        System.out.println("Are there users with a surname starting with 'S' or 'A': " + hasUsersWithSA);
        return hasUsersWithSA;
    }

    public static boolean checkIfAllUsersOver18(List<User> users) {
        boolean allUsersOver18 = users.stream()
                .allMatch(user -> user.getAge() > 18);
        System.out.println("Are all users over 18 years old: " + allUsersOver18);
        return allUsersOver18;
    }
}
