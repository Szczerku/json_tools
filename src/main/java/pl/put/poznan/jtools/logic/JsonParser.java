package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    public static JsonNode parse(String jsonString) throws JsonProcessingException  {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(jsonString);
    }
}
