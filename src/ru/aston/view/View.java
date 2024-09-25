package ru.aston.view;

import ru.aston.controller.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private static View instance;
    List<Object> objectList;

    private Scanner scanner;
    private Controller controller;

    public static View getInstance() {
        if (instance == null) {
            instance = new View();
        }
        return instance;
    }

    private View() {
        this.scanner = new Scanner(System.in);
        this.controller = Controller.getInstance();
        this.objectList = new ArrayList<>();
    }

    public void run() {
        int menuAction = -1;
        System.out.println("***** ASTON PROJECT *****");
        System.out.println();
        System.out.println("Choose action:");
        System.out.println("1. Will you choose an object of which class you will create? (barrel, animal, person)");
        System.out.println("2. Exit");

        System.out.print("\nAction: ");
        String input = scanner.nextLine();
        menuAction = Integer.parseInt(input);
        while (menuAction != 2) {
            menuAction = runMenu();

            switch (menuAction) {
                case 1:
                    selectObject();
                    break;
                case 2:
                    System.out.println("\n Good bye! See you soon :)");
                    break;
                default:
                    System.out.println("Error: Incorrect value, please choose correct");
                    break;
            }
        }
    }

    private int runMenu() {
        System.out.println();
        System.out.println("Choose action:");
        System.out.println("1. Will you choose an object of which class you will create? (barrel, animal, person)");
        System.out.println("2. Exit");

        System.out.print("\nAction: ");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    private void selectObject() {
        System.out.println("1. Person.");
        System.out.println("2. Animal. ");
        System.out.println("3. Barrel. ");
        System.out.print("\nAction: ");
        String input = scanner.nextLine();
        Integer typeObject = Integer.valueOf(input);

        System.out.println("Will you choose the type of data download?");
        System.out.println("1. From file.");
        System.out.println("2. From console. ");
        System.out.println("3. Random. ");
        System.out.print("\nAction: ");
        String input2 = scanner.nextLine();
        Integer typeImport = Integer.valueOf(input2);

        System.out.println("Enter the number of object. ");
        System.out.print("\nAction: ");
        Integer numberObject = null;
        boolean validSize = true;
        while (validSize) {
            Integer input3 = scanner.nextInt();
            numberObject = Integer.valueOf(input3);
            if (numberObject < 0) {
                System.out.println("The size of the array cannot be a negative number.");
                validSize = true;
            } else {
                validSize = false;
            }
        }

        objectList = controller.addList(typeObject, typeImport, numberObject);
        System.out.println(objectList);

        scanner.nextLine();
    }

    // методы сортировки, поиска
}