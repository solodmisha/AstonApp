// Класс Животное
public class Animal implements Comparable<Animal> {
    private final String species;
    private final String eyeColor;
    private final boolean hasFur;

    private Animal(Builder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.hasFur = builder.hasFur;
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
        return "Animal{species='" + species + "', eyeColor='" + eyeColor + "', hasFur=" + hasFur + "}";
    }
}
