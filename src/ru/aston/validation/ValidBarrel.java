package ru.aston.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.apache.commons.io.FileUtils;
import ru.aston.importFile.Constants;
import ru.aston.importFile.ImportExeption;
import ru.aston.model.Barrel;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ValidBarrel implements ValidStrategy{
    @Override
    public List<Barrel> isValidImport(File barrelJson) throws IOException, ImportExeption {
        List<Barrel> barrelList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);

        File personSchemaFile = new File(Constants.PATH_PERSON_SCHEMA);
        String personSchemaString = FileUtils.readFileToString(personSchemaFile, StandardCharsets.UTF_8);

        JsonNode personJsonNode = objectMapper.readTree(barrelJson);

        JsonSchema jsonSchema = schemaFactory.getSchema(personSchemaString);
        Set<ValidationMessage> validationResult = jsonSchema.validate(personJsonNode);

        if (!validationResult.isEmpty()) {
            throw new ImportExeption("Import error!");
        }
        barrelList = Arrays.asList(objectMapper.readValue(barrelJson, Barrel[].class));
        return barrelList;
    }
}

