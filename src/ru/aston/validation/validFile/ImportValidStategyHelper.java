package ru.aston.validation.validFile;

import ru.aston.importFile.Constants;

import java.util.HashMap;
import java.util.Map;

public class ImportValidStategyHelper {
    private static ImportValidStategyHelper instance;
    private final Map<Integer, ValidStrategy> validStrategyMap;

    public static ImportValidStategyHelper getInstance() {
        if (instance == null) {
            instance = new ImportValidStategyHelper();
        }
        return instance;
    }
    public ImportValidStategyHelper() {
        this.validStrategyMap = new HashMap<>();
        this.validStrategyMap.put(Constants. PERSON, new ValidPerson());
        this.validStrategyMap.put(Constants.ANIMAL, new ValidAnimal());
        this.validStrategyMap.put(Constants.BARREL, new ValidBarrel());
    }

       public ValidStrategy resolveValidStrategy(Integer strategyID) {
        return  this.validStrategyMap.get(strategyID);
    }
}
