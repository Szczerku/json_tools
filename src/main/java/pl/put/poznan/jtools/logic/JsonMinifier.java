package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;

/***
 * class designed for text processing with a focus on minify
 */
public class JsonMinifier extends JsonDecorator{
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
        JsonNode jsonNode = JsonParser.parse(jsonString);
        return jsonNode.toString();
    }
}

