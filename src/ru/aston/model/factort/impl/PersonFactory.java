package ru.aston.model.factort.impl;

import ru.aston.model.Person;
import ru.aston.model.factort.ObjectFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonFactory implements ObjectFactory {

    private Random random = new Random();

    @Override
    public Object create() {

        Person person = new Person();
        person.setGender(getGender());
        person.setAge(getAge());
        person.setLastName(
                (person.getGender().equals("Женский")) ? getLastName() + "а" : getLastName()
        );
        return person;
    }

    private String getGender() {

        List<String> genders  = new ArrayList<>(
                Arrays.asList(
                        "Мужской", "Женский"
                )
        );
        int ind = random.nextInt(genders.size());
        return genders.get(ind);
    }

    private int getAge() {
        return random.nextInt(90) + 1;
    }

    private String getLastName() {
        List<String> lastNames = new ArrayList<>(
                Arrays.asList(
                        "Иванов","Петров","Сидоров",
                        "Ефремов","Толстов"
                )
        );
        int ind = random.nextInt(lastNames.size());
        return lastNames.get(ind);
    }
}

