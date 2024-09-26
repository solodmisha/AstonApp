package ru.aston.validation.validConsole;

import ru.aston.importFile.Constants;

import java.util.HashMap;
import java.util.Map;

public class ImportValidConsoleStrategyHelper {
    private static ImportValidConsoleStrategyHelper instance;
    private final Map<Integer, ValidStrategyConsole> validStrategyConsoleMap;

    public static ImportValidConsoleStrategyHelper getInstance() {
        if (instance == null) {
            instance = new ImportValidConsoleStrategyHelper();
        }
        return instance;
    }

    public ImportValidConsoleStrategyHelper() {
        this.validStrategyConsoleMap = new HashMap<>();
        this.validStrategyConsoleMap.put(Constants.PERSON, new ValidPersonConsole());
        this.validStrategyConsoleMap.put(Constants.ANIMAL, new ValidAnimalConsole());
        this.validStrategyConsoleMap.put(Constants.BARREL, new ValidBarrelConsole());
    }

    public ValidStrategyConsole resolveValidConsoleStrategy(Integer strategyID) {
        return this.validStrategyConsoleMap.get(strategyID);
    }
}


