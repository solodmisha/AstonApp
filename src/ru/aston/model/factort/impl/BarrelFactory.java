package ru.aston.model.factort.impl;

import ru.aston.model.Barrel;
import ru.aston.model.factort.ObjectFactory;
import ru.aston.model.factort.ObjectsCreated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BarrelFactory implements ObjectFactory {

    private Random random = new Random();

    @Override
    public ObjectsCreated create() {

        return new Barrel.Builder()
                .volume(getVolume())
                .storedMaterial(getMaterialInBarrel())
                .material(getMaterial())
                .build();
    }

    private int getVolume() {

        List<Integer> volumes = new ArrayList<>(
                Arrays.asList(
                        20, 50, 100, 200, 500, 1000
                )
        );
        int ind = random.nextInt(volumes.size());
        return volumes.get(ind);
    }

    private String getMaterialInBarrel() {
        List<String> materials  = new ArrayList<>(
                Arrays.asList(
                        "Сыпучий", "Жидкий"
                )
        );
        int ind = random.nextInt(materials.size());
        return materials.get(ind);
    }

    private String getMaterial() {
        List<String> materials = new ArrayList<>(
                Arrays.asList(
                        "Алюминий", "Сталь", "Пластмасса"
                )
        );
        int ind = random.nextInt(materials.size());
        return materials.get(ind);
    }
}

