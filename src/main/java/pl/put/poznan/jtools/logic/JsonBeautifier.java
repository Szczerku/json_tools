package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBeautifier extends JsonDecorator{
    public JsonBeautifier(JsonObjectInterface jsonObject){
        super(jsonObject);
    }

    public String decorate() {
        return super.decorate() + decorateBeautify();
    }
    public String decorateBeautify(){
        return " beautified";
    }

    public static String beautify(String jsonString) {
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
