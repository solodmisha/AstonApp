package ru.aston.importFile.downloadType;

import ru.aston.importFile.ImportStrategyDownloads;
import ru.aston.validation.validConsole.ImportValidConsoleStrategyHelper;
import ru.aston.validation.validConsole.ValidStrategyConsole;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportFromConsole implements ImportStrategyDownloads<Object> {
    @Override
    public List<Object> store(Integer typeClass, Integer arraySize) throws IOException {
        int size = 0;
        List<Object> objectList = new ArrayList<>();
        ImportValidConsoleStrategyHelper importValidConsoleStrategyHelper = ImportValidConsoleStrategyHelper.getInstance();
        ValidStrategyConsole validStrategyConsole = importValidConsoleStrategyHelper.resolveValidConsoleStrategy(typeClass);

        while (size!=arraySize){
            objectList.add(validStrategyConsole.Import());
            size++;
        }
        return objectList;
    }
}
