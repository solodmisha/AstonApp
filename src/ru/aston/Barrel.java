package ru.aston;

import ru.aston.factort.ObjectsCreated;

public class Barrel implements Comparable<Barrel>, ObjectsCreated {
    private final double volume;
    private final String storedMaterial;
    private final String material;

    private Barrel(Builder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.material = builder.material;
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
    public int compareTo(Barrel other) {
        return Double.compare(this.volume, other.volume);
    }

    @Override
    public String toString() {
        return "Barrel{volume=" + volume + ", storedMaterial='" + storedMaterial + "', material='" + material + "'}";
    }
}


