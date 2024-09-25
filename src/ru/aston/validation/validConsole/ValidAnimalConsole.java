package ru.aston.validation.validConsole;

import ru.aston.model.Animal;

import java.util.Scanner;

public class ValidAnimalConsole implements ValidStrategyConsole<Animal> {
    @Override
    public Animal Import() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a \"Animal\" object.");
        System.out.println("Enter the species of the animal: ");
        String species = scanner.nextLine();

        System.out.println("Enter the eye color of the animal: ");
        String eyeColor = scanner.nextLine();

        System.out.println("Does the animal have fur (yes/no): ");
        String hasFur = scanner.nextLine();
        boolean hasFurBoolean = false;
        if ("yes".equalsIgnoreCase(hasFur)) {
            hasFurBoolean = true;
        }

        Animal animal = new Animal.Builder().
                species(species).
                eyeColor(eyeColor).
                hasFur(hasFurBoolean).
                build();
        System.out.println("\"Animal\" is created.");
        System.out.println();
        return animal;
    }
}
