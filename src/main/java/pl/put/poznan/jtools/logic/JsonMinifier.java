package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;

/***
 * class designed for text processing with a focus on minify
 */
public class JsonMinifier extends JsonDecorator{
    public JsonMinifier(JsonObjectInterface jsonObject){
        super(jsonObject);
    }

    public String decorate() {
        return decorateMinify();
    }

    /***
     * removes unnecessary characters from the code without changing the functionality
     * parse method parses a JSON string, constructing the JavaScript value or object described by the string
     * @return the parsed string
     */
    public String decorateMinify() {
        String jsonString = super.decorate();
        JsonNode jsonNode = JsonParser.parse(jsonString);
        return jsonNode.toString();
    }
}

