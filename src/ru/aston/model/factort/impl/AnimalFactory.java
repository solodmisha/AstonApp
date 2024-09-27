package ru.aston.model.factort.impl;

import ru.aston.model.Animal;
import ru.aston.model.factort.ObjectFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AnimalFactory implements ObjectFactory {

    private Random random = new Random();

    @Override
    public Object create() {

        Animal animal = new Animal();
        animal.setSpecies(geTypeAnimals());
        animal.setEyeColor(getEyeColor());
        animal.setHasFur(animal.getSpecies().equals("Млекопитающие"));

        return animal;
    }

    private String geTypeAnimals() {
        List<String> animalTypes = new ArrayList<>(
                Arrays.asList(
                        "Земноводные","Пресмыкающиеся","Рыбы",
                        "Насекомые","Птицы","Млекопитающие"
                )
        );
        int ind = random.nextInt(animalTypes.size());
        return animalTypes.get(ind);
    }

    private String getEyeColor() {
        List<String> eyeColor = new ArrayList<>(
                Arrays.asList(
                        "синий","голубой","серый",
                        "зелёный","жёлтый","карий"
                )
        );
        int ind = random.nextInt(eyeColor.size());
        return eyeColor.get(ind);
    }

    private String getWoolColor() {
        List<String> woolColors = new ArrayList<>(
                Arrays.asList(
                        "серая","коричневая","чёрная",
                        "молочная","бежевая"
                )
        );
        int ind = random.nextInt(woolColors.size());
        return woolColors.get(ind);
    }
}
