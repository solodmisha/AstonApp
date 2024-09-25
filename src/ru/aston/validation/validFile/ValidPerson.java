package ru.aston.validation.validFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import ru.aston.importFile.Constants;
import org.apache.commons.io.FileUtils;
import ru.aston.importFile.ImportExeption;
import ru.aston.model.Person;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ValidPerson implements ValidStrategy {
    @Override
    public List<Person> isValidImport(File personJson) throws IOException, ImportExeption {
        List<Person> personList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);

        File personSchemaFile = new File(Constants.PATH_PERSON_SCHEMA);
        String personSchemaString = FileUtils.readFileToString(personSchemaFile, StandardCharsets.UTF_8);

        JsonNode personJsonNode = objectMapper.readTree(personJson);

        JsonSchema jsonSchema = schemaFactory.getSchema(personSchemaString);
        Set<ValidationMessage> validationResult = jsonSchema.validate(personJsonNode);

        if (!validationResult.isEmpty()) {
            throw new ImportExeption("Import error!");
        }
        personList = Arrays.asList(objectMapper.readValue(personJson, Person[].class));
        return personList;
    }
}
