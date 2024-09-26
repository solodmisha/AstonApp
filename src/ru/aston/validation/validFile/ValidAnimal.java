package ru.aston.validation.validFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.apache.commons.io.FileUtils;
import ru.aston.importFile.Constants;
import ru.aston.importFile.ImportExeption;
import ru.aston.model.Animal;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ValidAnimal implements ValidStrategy<Animal>{
    @Override
    public List<Animal> isValidImport(File animalJson) throws IOException, ImportExeption {
        List<Animal> animalList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);

        File personSchemaFile = new File(Constants.PATH_ANIMAL_SCHEMA);
        String personSchemaString = FileUtils.readFileToString(personSchemaFile, StandardCharsets.UTF_8);

        JsonNode personJsonNode = objectMapper.readTree(animalJson);

        JsonSchema jsonSchema = schemaFactory.getSchema(personSchemaString);
        Set<ValidationMessage> validationResult = jsonSchema.validate(personJsonNode);

        if (!validationResult.isEmpty()) {
            throw new ImportExeption("Import error!");
        }
        animalList = Arrays.asList(objectMapper.readValue(animalJson, Animal[].class));
        return animalList;
    }
}
