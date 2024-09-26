package ru.aston.view;

import ru.aston.controller.Controller;
import ru.aston.searching.BinarySearch;
import ru.aston.sorting.EvenSortingStrategy;
import ru.aston.sorting.TimSortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private static View instance;
    List objectList;

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

//        System.out.println("Choose action:");
//        System.out.println("1. Will you choose an object of which class you will create? (barrel, animal, person)");
//        System.out.println("2. Exit");
//
//        System.out.print("\nAction: ");
//        String input = scanner.nextLine();
//        menuAction = Integer.parseInt(input);
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
            numberObject = scanner.nextInt();
            if (numberObject < 0) {
                System.out.println("The size of the array cannot be a negative number.");
            } else {
                validSize = false;
            }
        }

        objectList = controller.addList(typeObject, typeImport, numberObject);
        System.out.println(objectList);
        System.out.println();
        actions();
        scanner.nextLine();
    }

    private void actions() {
        boolean isSorted = false;
        while (true) {
            System.out.println("1. To sort the collection");
            System.out.println("2. To sort only even id's in the collection");
            System.out.println("3. Find an object by id");
            System.out.println("4. Exit");
            int input = scanner.nextInt();
            TimSortStrategy timSortStrategy = new TimSortStrategy();

            switch (input) {
                case 1:
                    timSortStrategy.sort(objectList, objectList.size());
                    isSorted = true;
                    System.out.println(objectList);
                    break;
                case 2:
                    EvenSortingStrategy evenSortingStrategy = new EvenSortingStrategy();
                    evenSortingStrategy.sort(objectList, objectList.size());
                    System.out.println(objectList);
                    break;
                case 3:
                    if(!isSorted) {
                        timSortStrategy.sort(objectList, objectList.size());
                        isSorted = true;
                    }
                    while(true) {
                        System.out.println("Enter id: ");
                        long id = scanner.nextLong();
                        if (id < 0) {
                            System.out.println("Please enter the correct index");
                            System.out.println();
                        } else if (id >= objectList.size()) {
                            System.out.println("Id is greater than collection size");
                        } else {
                            BinarySearch search = new BinarySearch();
                            int index = search.binarySearch(objectList, id);
                            if (index >= 0) {
                                System.out.println(objectList.get(index));
                            } else {
                                System.out.println("Id is not found");
                            }
                            break;
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Error: Incorrect value, please choose correct");
            }
        }
    }
}