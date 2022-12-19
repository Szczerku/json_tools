package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
 * class designed for text processing with a focus on beautify
 */
public class JsonBeautifier extends JsonDecorator{
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

        JsonNode jsonNode = JsonParser.parse(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String indentedJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            return indentedJsonString;
        }
        catch (Exception e) {
            // TODO: Better exception handling
            System.out.println("JsonBeautifier failed");
            return new String();
        }
    }
}
