package ru.aston.model;

import ru.aston.model.factort.ObjectsCreated;

// Класс Животное
public class Animal implements Comparable<Animal>, ObjectsCreated {
    private final String species;
    private final String eyeColor;
    private final boolean hasFur;

    private static Long count = 0L;
    private final Long id;

    private Animal(Builder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.hasFur = builder.hasFur;

        count++;
        this.id = getCount();
    }

    public Long getId() {
        return id;
    }

    public static class Builder {
        private String species;
        private String eyeColor;
        private boolean hasFur;

        public Builder species(String species) {
            this.species = species;
            return this;
        }

        public Builder eyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder hasFur(boolean hasFur) {
            this.hasFur = hasFur;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    @Override
    public int compareTo(Animal other) {
        return this.species.compareTo(other.species);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hasFur=" + hasFur +
                ", id=" + id +
                '}';
    }

    private Long getCount() {
        return count;
    }
}

