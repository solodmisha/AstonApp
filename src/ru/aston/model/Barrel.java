package ru.aston.model;

import ru.aston.sorting.Sortable;
import ru.aston.model.factort.ObjectsCreated;

public class Barrel implements Sortable, ObjectsCreated {
    private final double volume;
    private final String storedMaterial;
    private final String material;

    private static Long count = 0L;
    private final Long id;

    private Barrel(Builder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.material = builder.material;

        count++;
        this.id = getCount();
    }

    public Long getId() {
        return id;
    }

    public static class Builder {
        private double volume;
        private String storedMaterial;
        private String material;

        public Builder volume(double volume) {
            this.volume = volume;
            return this;
        }

        public Builder storedMaterial(String storedMaterial) {
            this.storedMaterial = storedMaterial;
            return this;
        }

        public Builder material(String material) {
            this.material = material;
            return this;
        }

        public Barrel build() {
            return new Barrel(this);
        }
    }

    @Override
    public String toString() {
        return "Barrel{" +
                "volume=" + volume +
                ", storedMaterial='" + storedMaterial + '\'' +
                ", material='" + material + '\'' +
                ", id=" + id +
                '}';
    }

    private Long getCount() {
        return count;
    }
}


