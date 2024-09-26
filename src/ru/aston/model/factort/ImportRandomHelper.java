package ru.aston.model.factort;

import ru.aston.importFile.Constants;
import ru.aston.model.factort.impl.AnimalFactory;
import ru.aston.model.factort.impl.BarrelFactory;
import ru.aston.model.factort.impl.PersonFactory;

import java.util.HashMap;
import java.util.Map;

public class ImportRandomHelper {
    private static ImportRandomHelper instance;
    private final Map<Integer, ObjectFactory> objectFactoryMap;

    public static ImportRandomHelper getInstance() {
        if (instance == null) {
            instance = new ImportRandomHelper();
        }
        return instance;
    }

    public ImportRandomHelper() {
        this.objectFactoryMap = new HashMap<>();
        this.objectFactoryMap.put(Constants.PERSON, new PersonFactory());
        this.objectFactoryMap.put(Constants.ANIMAL, new AnimalFactory());
        this.objectFactoryMap.put(Constants.BARREL, new BarrelFactory());
    }

    public ObjectFactory resolveRandomStrategy(Integer strategyID) {
        return this.objectFactoryMap.get(strategyID);
    }
}
