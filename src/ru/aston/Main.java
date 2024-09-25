package ru.aston;

import ru.aston.model.Animal;
import ru.aston.searching.BinarySearch;
import ru.aston.sorting.TimSortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        List<Animal> animals = new ArrayList<>();

        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Заполнить массив данных");
            System.out.println("2. Отсортировать массив");
            System.out.println("3. Выполнить бинарный поиск");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    animals = fillData();
                    System.out.println("Данные успешно заполнены: " + animals);
                    break;
                case 2:
                    TimSortStrategy sorting = new TimSortStrategy();
                    sorting.sort(animals, animals.size());
                    System.out.println("Отсортированный массив: " + animals);
                    break;
                case 3:
                    System.out.println("Введите id животного для поиска:");
                    Long id = scanner.nextLong();

                    int index = BinarySearch.binarySearch(animals, id);
                    if (index != -1) {
                        System.out.println("Найдено: " + animals.get(index));
                    } else {
                        System.out.println("Не найдено");
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    public static List<Animal> fillData() {
        List<Animal> animals = new ArrayList<>();
        // Логика заполнения данными (рандом, вручную или из файла)
        animals.add(new Animal.Builder().species("Собака").eyeColor("Карие").hasFur(true).build());
        animals.add(new Animal.Builder().species("Кошка").eyeColor("Зеленые").hasFur(true).build());
        return animals;
    }
}
