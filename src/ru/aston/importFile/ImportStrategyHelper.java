package ru.aston.importFile;

import ru.aston.importFile.downloadType.ImportFromConsole;
import ru.aston.importFile.downloadType.ImportFromFile;
import ru.aston.importFile.downloadType.ImportRandom;

import java.util.HashMap;
import java.util.Map;

public class ImportStrategyHelper {
    private static ImportStrategyHelper instance;
    private final Map<Integer, ImportStrategyDownloads<Object>> importStrategyDownloadsMap;

    public static ImportStrategyHelper getInstance() {
        if (instance == null) {
            instance = new ImportStrategyHelper();
        }
        return instance;
    }

    private ImportStrategyHelper() {
        this.importStrategyDownloadsMap = new HashMap<>();
        this.importStrategyDownloadsMap.put(Constants.IMPORT_FROM_FILE, new ImportFromFile());
        this.importStrategyDownloadsMap.put(Constants.IMPORT_FROM_CONSOLE, new ImportFromConsole());
        this.importStrategyDownloadsMap.put(Constants.IMPORT_RANDOM, new ImportRandom());
    }

    public ImportStrategyDownloads<Object> resolveDownloadsStrategy(Integer strategyID) {
        return this.importStrategyDownloadsMap.get(strategyID);
    }
 }
