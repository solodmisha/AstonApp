package importFile.downloadType;

import com.fasterxml.jackson.databind.ObjectMapper;
import importFile.ImportExeption;
import importFile.ImportStrategyDownloads;
import model.Person;
import validation.ImportValidStategyHelper;
import validation.ValidStrategy;

import java.io.File;
import java.io.IOException;

public class ImportFromFile implements ImportStrategyDownloads {
    @Override
    public void store(String nameFile, String typeClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(nameFile);

        ValidStrategy validStrategy = ImportValidStategyHelper.getInstance().resolveValidStrategy(typeClass);

        if (validStrategy.isValidImport(jsonFile)) {
            Person person = objectMapper.readValue(jsonFile, Person.class);
            System.out.println("Person.class - " + person);
        } else {
            try {
                throw new ImportExeption("Import error!");
            } catch (ImportExeption e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
