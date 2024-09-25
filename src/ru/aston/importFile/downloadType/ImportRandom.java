package ru.aston.importFile.downloadType;

import ru.aston.importFile.ImportStrategyDownloads;
import ru.aston.model.factort.ImportRandomHelper;
import ru.aston.model.factort.ObjectFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportRandom implements ImportStrategyDownloads<Object> {
    @Override
    public List<Object> store(Integer typeClass, Integer arraySize) {
        int size = 0;
        List<Object> objectList = new ArrayList<>();
        ImportRandomHelper importRandomHelper = ImportRandomHelper.getInstance();
        ObjectFactory objectFactory = importRandomHelper.resolveRandomStrategy(typeClass);

        while (size!=arraySize){
            objectList.add(objectFactory.create());
            size++;
        }
        return objectList;
    }
}
