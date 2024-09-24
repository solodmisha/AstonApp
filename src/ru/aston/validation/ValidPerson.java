package ru.aston.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import ru.aston.importFile.Constants;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class ValidPerson implements ValidStrategy {
    @Override
    public Boolean isValidImport(File personJson) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);

        File personSchemaFile = new File(Constants.PATH_PERSON_SCHEMA);
        String personSchemaString = FileUtils.readFileToString(personSchemaFile, StandardCharsets.UTF_8);

        JsonNode personJsonNode = objectMapper.readTree(personJson);

        JsonSchema jsonSchema = schemaFactory.getSchema(personSchemaString);
        Set<ValidationMessage> validationResult = jsonSchema.validate(personJsonNode);

        if (validationResult.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
