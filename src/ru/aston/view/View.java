package ru.aston.view;

import ru.aston.controller.Controller;

import java.util.Scanner;

public class View {
    private static View instance;

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
    }

    public void run() {
        int menuAction = -1;
        System.out.println("***** ASTON PROJECT *****");
        while (menuAction != 5) {
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
        System.out.println("1. Barrel.");
        System.out.println("2. Animal. ");
        System.out.println("3. Person. ");
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
        boolean valdSize = true;
        while (valdSize) {
            Integer input3 = scanner.nextInt();
            numberObject = Integer.valueOf(input3);
            if (numberObject < 0) {
                System.out.println("The size of the array cannot be a negative number.");
                valdSize = true;
            } else {
                valdSize = false;
            }
        }

        controller.addList(typeObject, typeImport, numberObject);

    }

    // методы сортировки, поиска
}