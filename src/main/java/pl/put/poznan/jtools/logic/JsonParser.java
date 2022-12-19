package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonParser {
    private final Logger logger = LoggerFactory.getLogger(JsonParser.class);
    public JsonNode parse(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(jsonString);
            return root;
        }
        catch (Exception e) {
            logger.error("JsonParser failed!");
            return mapper.nullNode();
        }
    }
}
