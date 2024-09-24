package ru.aston;

import ru.aston.factort.ObjectsCreated;

public class Person implements Comparable<Person>, ObjectsCreated {
    private final String gender;
    private final int age;
    private final String lastName;

    private Person(Builder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.lastName = builder.lastName;
    }

    public static class Builder {
        private String gender;
        private int age;
        private String lastName;

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public int compareTo(Person other) {
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return "Person{gender='" + gender + "', age=" + age + ", lastName='" + lastName + "'}";
    }
}

