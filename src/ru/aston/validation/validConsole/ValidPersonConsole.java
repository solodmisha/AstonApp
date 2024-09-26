package ru.aston.validation.validConsole;


import ru.aston.model.Person;

import java.util.Scanner;

public class ValidPersonConsole implements ValidStrategyConsole<Person> {
    @Override
    public Person Import() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a \"Person\" object.");
        System.out.println("Enter the gender of the person: ");
        String gender = scanner.nextLine();

        System.out.println("Enter the lastName of the person: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter the age of the person: ");
        Integer age = null;
        boolean validAge = true;
        while (validAge) {
            age = scanner.nextInt();
            if (age < 0) {
                System.out.println("The age of the person cannot be a negative number.");
            } else {
                validAge = false;
            }
        }
        Person person = new Person.Builder().
                gender(gender).
                age(age).
                lastName(lastName).
                build();
        System.out.println("\"Person\" is created.");
        System.out.println();
        return person;
    }
}
