
package com.pluralsight.streams;

import com.pluralsight.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        people.add(new Person("James", "Smith", 22));
        people.add(new Person("Emily", "Johnson", 33));
        people.add(new Person("Michael", "Williams", 44));
        people.add(new Person("Sarah", "Brown", 21));
        people.add(new Person("David", "Jones", 11));
        people.add(new Person("Jessica", "Smith", 99));
        people.add(new Person("Daniel", "Miller", 55));
        people.add(new Person("Ashley", "Davis", 88));
        people.add(new Person("Christopher", "Wilson", 66));
        people.add(new Person("Olivia", "Johnson", 77));

        System.out.println("Search by first or last name:");
        String search = scanner.nextLine();

        // Step 1: Search using stream and filter
        List<Person> matches = people
                .stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(search)
                        || person.getLastName().equalsIgnoreCase(search))
                .toList();

        if (matches.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Matching people:");

            matches.forEach(person -> System.out.println(
                    person.getFirstName() + " " + person.getLastName()));
        }


        int totalAge = people
                .stream()
                .mapToInt(Person::getAge)
                .sum();

        double avrAge = (double) totalAge / people.size();


        /*int oldestAge = people
                .stream()
                .map(person -> person.getAge())
                .reduce(people.get(0).getAge(),
                        (oldest, age) -> Math.max(oldest, age));*/

// oldest age
        List<Integer> sortedAges = people
                .stream()
                .map(Person::getAge)
                .sorted()
                .toList();

        int oldestAge = sortedAges.get(sortedAges.size() - 1);

// youngest age
        int youngestAge = sortedAges.get(0);


        /*int youngestAge = people
                .stream()
                .map(person -> person.getAge())
                .reduce(people.get(0).getAge(),
                        (youngest, age) -> Math.min(youngest, age));*/

        System.out.println("Average age: " + avrAge);
        System.out.println("Oldest age: " + oldestAge);
        System.out.println("Youngest age: " + youngestAge);
    }
}
