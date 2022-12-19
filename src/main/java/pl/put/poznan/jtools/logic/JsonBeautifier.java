package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * class designed for text processing with a focus on beautify
 */
public class JsonBeautifier extends JsonDecorator{
    /***
     * Gives logging capabilities to the class
     */
    private final Logger logger = LoggerFactory.getLogger(JsonBeautifier.class);
    /***
     * Creates beautifier
     * @param jsonObject object containing json text to minify
     */
    public JsonBeautifier(JsonObjectInterface jsonObject){
        super(jsonObject);
    }

    /***
     * Decorator function
     * @return run decorator implementation of beautifier
     */
    public String decorate() {
        return decorateBeautify();
    }

    /***
     * adds whitespaces to JSON text to make it more human readable
     * @return the parsed string
     */
    public String decorateBeautify() {
        String jsonString = super.decorate();

        JsonParser parser = new JsonParser();
        JsonNode jsonNode = parser.parse(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String indentedJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            return indentedJsonString;
        }
        catch (Exception e) {
            logger.error("decorateBeautify failed");
            return new String();
        }
    }
}
