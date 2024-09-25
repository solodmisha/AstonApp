package ru.aston.validation.validConsole;

import ru.aston.model.Barrel;

import java.util.Scanner;

public class ValidBarrelConsole implements ValidStrategyConsole<Barrel> {

    @Override
    public Barrel Import() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creating a \"barrel\" object.");
        System.out.println("Enter the stored material of the barrel: ");
        String storedMaterial = scanner.nextLine();

        System.out.println("Enter the material of the barrel: ");
        String material = scanner.nextLine();

        System.out.println("Enter the volume of the barrel: ");
        Double volume = null;
        boolean validvolume = true;
        while (validvolume) {
            volume = scanner.nextDouble();
            if (volume < 0) {
                System.out.println("The volume of the barrel cannot be a negative number.");
            } else {
                validvolume = false;
            }
        }

        Barrel barrel = new Barrel.Builder().
                volume(volume).
                storedMaterial(storedMaterial).
                material(material).
                build();
        System.out.println("\"Barrel\" is created.");
        System.out.println();
        return barrel;
    }
}

