package ru.aston.importFile.downloadType;

import ru.aston.importFile.ImportExeption;
import ru.aston.importFile.ImportStrategyDownloads;
import ru.aston.validation.validFile.ImportValidStategyHelper;
import ru.aston.validation.validFile.ValidStrategy;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ImportFromFile implements ImportStrategyDownloads<Object> {
    @Override
    public List<Object> store(Integer typeClass, Integer arraySize) {
        System.out.print("Enter the file name: ");
        Scanner scanner = new Scanner(System.in);
        String nameFile = "src/resources/" + scanner.nextLine();

        File jsonFile = new File(nameFile);

        ValidStrategy validStrategy = ImportValidStategyHelper.getInstance().resolveValidStrategy(typeClass);

        List<Object> objectList = null;
        try {
            objectList = validStrategy.isValidImport(jsonFile);
            System.out.println(objectList);
        } catch (ImportExeption | IOException e) {
            System.out.println(e.getMessage());
        }
        return objectList;
    }
}
