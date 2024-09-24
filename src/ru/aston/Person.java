package ru.aston;

import ru.aston.factort.ObjectsCreated;

public class Person implements Sortable, ObjectsCreated {
    private final String gender;
    private final int age;
    private final String lastName;

    private static Long count = 0L;
    private final Long id;

    private Person(Builder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.lastName = builder.lastName;

        count++;
        this.id = getCount();
    }

    public Long getId() {
        return id;
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
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    private Long getCount() {
        return count;
    }
}

