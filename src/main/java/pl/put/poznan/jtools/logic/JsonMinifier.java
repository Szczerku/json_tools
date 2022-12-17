package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonMinifier extends JsonDecorator{
    public JsonMinifier(JsonObjectInterface jsonObject){
        super(jsonObject);
    }

    public String decorate() {
        return decorateMinify();
    }
    public String decorateMinify() {
        String jsonString = super.decorate();
        JsonNode jsonNode = JsonParser.parse(jsonString);
        return jsonNode.toString();
    }
}
