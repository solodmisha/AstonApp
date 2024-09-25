package ru.aston.importFile.downloadType;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aston.importFile.ImportExeption;
import ru.aston.importFile.ImportStrategyDownloads;
import ru.aston.validation.ImportValidStategyHelper;
import ru.aston.validation.ValidStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ImportFromFile implements ImportStrategyDownloads {
    @Override
    public List<Object> store(Integer typeClass, Integer arraySize) throws IOException {
        System.out.print("Enter the file name: ");
        Scanner scanner = new Scanner(System.in);
        String nameFile = "src/resources/" + scanner.nextLine();

        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(nameFile);

        ValidStrategy validStrategy = ImportValidStategyHelper.getInstance().resolveValidStrategy(typeClass);

        List<Object> objectList = null;
        try {
            objectList = validStrategy.isValidImport(jsonFile);
            System.out.println(objectList);
        } catch (ImportExeption e) {
            System.out.println(e.getMessage());
        }
        return objectList;
    }
}
