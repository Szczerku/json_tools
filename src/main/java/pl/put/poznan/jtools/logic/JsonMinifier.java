package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMinifier extends JsonDecorator{
    public JsonMinifier(JsonObjectInterface jsonObject){
        super(jsonObject);
    }


    public String decorate() {
        return super.decorate() + decorateMinify();
    }
    public String decorateMinify(){
        return " minified";
    }

    public static String minify(String jsonString) {
        JsonNode jsonNode = JsonParser.parse(jsonString);
        return jsonNode.toString();
    }
}
