
package com.pluralsight.loops;

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

        List<Person> matches = new ArrayList<>();

        for (Person person : people) {
            // if search is eqaual to first or lastname
            if (person.getFirstName().equalsIgnoreCase(search)
                    || person.getLastName().equalsIgnoreCase(search)) {
                matches.add(person);
            }
        }


        //if user uses incorrect name no matches. else print out the list of mathces
        if (matches.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Matching people:");
            for (Person person : matches) {
                System.out.println(person.getFirstName() + " "
                        + person.getLastName());
            }
        }

        // setting varaible to zero
        int totalAge = 0;

        int oldestAge = people.get(0).getAge();
        int youngestAge = people.get(0).getAge();

        for (Person person : people) {
            //goes threw list adds all ages together
            totalAge = totalAge + person.getAge();

            //while going threw list if the next person is older that the last they get stored as oldest age
            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }
            //Same as old but backwards
            if (person.getAge() < youngestAge) {
                youngestAge = person.getAge();
            }
        }


        //type casted the variable ints to doubles
        double avrAge = (double) totalAge / people.size();

        System.out.println("Average age: " + avrAge);
        System.out.println("Oldest age: " + oldestAge);
        System.out.println("Youngest age: " + youngestAge);
    }
}
