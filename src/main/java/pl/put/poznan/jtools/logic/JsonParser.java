package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    public static JsonNode parse(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(jsonString);
            return root;
        }
        catch (Exception e) {
            // TODO: Better exception handling
            System.out.println("JsonParser failed");
            return mapper.nullNode();
        }
    }
}
