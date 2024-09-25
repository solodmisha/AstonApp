package ru.aston.importFile.downloadType;

import ru.aston.importFile.ImportStrategyDownloads;
import ru.aston.validation.ImportValidStategyHelper;
import ru.aston.validation.ValidStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportFromConsole implements ImportStrategyDownloads {
    @Override
    public List<Object> store(Integer typeClass, Integer arraySize) throws IOException {
        List<Object> objectList = new ArrayList<>(arraySize);
        ValidStrategy validStrategy = ImportValidStategyHelper.getInstance().resolveValidStrategy(typeClass);

        return null;
    }
}
