package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelos.CredentialJson;
import utilities.Logs;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static final String credentialsPath = "src/test/resources/data/credenciales.json";

    public static CredentialJson getMapCredentials(){
        final var objectMapper = new ObjectMapper();

        try {
            return objectMapper.
                    readValue(new File(credentialsPath), CredentialJson.class);
        } catch (IOException ioException) {
            Logs.error("Error al leer json de crendentials: %s");
            throw new RuntimeException(ioException.getLocalizedMessage());
        }
    }
}
