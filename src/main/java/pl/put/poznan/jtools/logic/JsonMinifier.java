package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * class designed for text processing with a focus on minify
 */
public class JsonMinifier extends JsonDecorator{
    /***
     * Gives logging capabilities to the class
     */
    private final Logger logger = LoggerFactory.getLogger(JsonMinifier.class);
    /***
     * Creates minifier
     * @param jsonObject object containing json text to minify
     */
    public JsonMinifier(JsonObjectInterface jsonObject){
        super(jsonObject);
    }

    /***
     * Decorator function
     * @return run decorator implementation of minifier
     */
    public String decorate() {
        return decorateMinify();
    }

    /***
     * removes unnecessary characters from the code without changing the functionality
     * parse method parses a JSON string, toString generates String value of parsed JSON
     * @return the parsed string
     */
    public String decorateMinify() {
        String jsonString = super.decorate();
        JsonParser parser = new JsonParser();
        JsonNode jsonNode = parser.parse(jsonString);
        return jsonNode.toString();
    }
}

