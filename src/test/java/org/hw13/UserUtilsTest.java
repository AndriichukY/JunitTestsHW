package org.hw13;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)

public class UserUtilsTest {

    private static List<User> users;

    @BeforeAll
    static void setUp() {
        users = new ArrayList<>();
        users.add(new User("John", "Smith", 25));
        users.add(new User("Emily", "Davis", 20));
        users.add(new User("Michael", "Johnson", 35));
        users.add(new User("Sophia", "Williams", 30));
        users.add(new User("Daniel", "Brown", 19));
        users.add(new User("Olivia", "Miller", 22));
        users.add(new User("James", "Taylor", 28));
        users.add(new User("Emma", "Anderson", 40));
        users.add(new User("Alexander", "Jones", 19));
        users.add(new User("Isabella", "Wilson", 32));
    }

    @BeforeEach
    void print() {
        System.out.println("Test started.");
    }

    @Test
    void sortUsersByAge_PositiveTest() {
        List<User> sortedByAge = UserUtils.sortUsersByAge(users);
        assertEquals(19, sortedByAge.get(0).getAge());
        assertEquals(19, sortedByAge.get(1).getAge());
        assertEquals(20, sortedByAge.get(2).getAge());
    }

    @Test
    void sortUsersByAge_NegativeTest() {
        List<User> emptyList = new ArrayList<>();
        List<User> sortedByAge = UserUtils.sortUsersByAge(emptyList);
        assertTrue(sortedByAge.isEmpty());
    }

    @RepeatedTest(10)
    void calculateAverageAge_PositiveTest() {
        double averageAge = UserUtils.calculateAverageAge(users);
        assertEquals(27, averageAge);
    }

    @Test
    void calculateAverageAge_NegativeTest() {
        List<User> emptyList = new ArrayList<>();
        double averageAge = UserUtils.calculateAverageAge(emptyList);
        assertEquals(0, averageAge);
    }

   @Test
    void sortUsersByMultipleProperties_PositiveTest() {
        List<User> sortedByMultipleProperties = UserUtils.sortUsersByMultipleProperties(users);
        assertEquals("Alexander", sortedByMultipleProperties.get(0).getFirstName());
        assertEquals(19, sortedByMultipleProperties.get(0).getAge());
        assertEquals("Daniel", sortedByMultipleProperties.get(1).getFirstName());
        assertEquals(19, sortedByMultipleProperties.get(1).getAge());
    }

   @Test
    void sortUsersByMultipleProperties_NegativeTest() {
        List<User> emptyList = new ArrayList<>();
        List<User> sortedByMultipleProperties = UserUtils.sortUsersByMultipleProperties(emptyList);
        assertTrue(sortedByMultipleProperties.isEmpty());
    }

    @Test
    void checkUsersWithSpecificLastName_PositiveTest() {
        boolean hasUsersWithSA = UserUtils.checkUsersWithSpecificLastName(users);
        assertTrue(hasUsersWithSA);
    }

    @Test
    void checkUsersWithSpecificLastName_NegativeTest() {
        List<User> usersWithoutSALastName = new ArrayList<>();
        usersWithoutSALastName.add(new User("John", "Maven", 25));
        usersWithoutSALastName.add(new User("Emily", "Davis", 20));
        boolean hasUsersWithSA = UserUtils.checkUsersWithSpecificLastName(usersWithoutSALastName);
        assertFalse(hasUsersWithSA);
    }

    @Test
    void checkIfAllUsersOver18_PositiveTest() {
        boolean allUsersOver18 = UserUtils.checkIfAllUsersOver18(users);
        assertTrue(allUsersOver18);
    }

    @Test
    void checkIfAllUsersOver18_NegativeTest() {
        List<User> usersWithUnderage = new ArrayList<>();
        usersWithUnderage.add(new User("John", "Smith", 25));
        usersWithUnderage.add(new User("Emily", "Davis", 20));
        usersWithUnderage.add(new User("Michael", "Johnson", 35));
        usersWithUnderage.add(new User("Sophia", "Williams", 16));
        boolean allUsersOver18 = UserUtils.checkIfAllUsersOver18(usersWithUnderage);
        assertFalse(allUsersOver18);
    }

    @ParameterizedTest
    @MethodSource("sortUsersByAgeArguments")
    void testSortUsersByAge(List<User> users, List<User> expectedSortedUsers) {
        List<User> sortedUsers = UserUtils.sortUsersByAge(users);
        assertEquals(expectedSortedUsers, sortedUsers);
    }

    private static Stream<Arguments> sortUsersByAgeArguments() {
        List<User> users1 = new ArrayList<>(Arrays.asList(
                new User("John", "Smith", 25),
                new User("Emily", "Davis", 20),
                new User("Michael", "Johnson", 35)
        ));
        List<User> expectedSortedUsers1 = new ArrayList<>(Arrays.asList(
                new User("Emily", "Davis", 20),
                new User("John", "Smith", 25),
                new User("Michael", "Johnson", 35)
        ));

        List<User> users2 = new ArrayList<>(Arrays.asList(
                new User("Sophia", "Williams", 30),
                new User("Daniel", "Brown", 19),
                new User("Olivia", "Miller", 22)
        ));
        List<User> expectedSortedUsers2 = new ArrayList<>(Arrays.asList(
                new User("Daniel", "Brown", 19),
                new User("Olivia", "Miller", 22),
                new User("Sophia", "Williams", 30)
        ));

        return Stream.of(
                Arguments.of(users1, expectedSortedUsers1),
                Arguments.of(users2, expectedSortedUsers2)
        );
    }

    @AfterEach
    void printEnd() {
        System.out.println("Test ended.");
    }

    @AfterAll
    static void tearDown() {
        users = null;
    }
}
