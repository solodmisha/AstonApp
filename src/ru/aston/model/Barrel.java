package ru.aston.model;

import ru.aston.sorting.Sortable;
import ru.aston.model.factort.ObjectsCreated;

public class Barrel implements Sortable, ObjectsCreated {
    private double volume;
    private String storedMaterial;
    private String material;

    private static Long count = 0L;
    private Long id;

    private Barrel(Builder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.material = builder.material;

        count++;
        this.id = getCount();
    }

    public Barrel() {
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public void setStoredMaterial(String storedMaterial) {
        this.storedMaterial = storedMaterial;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setId(Long id) {
        this.id = id;
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


