package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;
import java.util.List;

public class JsonWhitelist extends JsonDecorator{
    public final List<String> whitelist;
    public JsonWhitelist(JsonObjectInterface jsonObject, List<String> whitelist){
        super(jsonObject);
        this.whitelist = whitelist;
    }
    public String decorate() {
        return decorateWhitelist(super.decorate(), this.whitelist);
    }
    public static String decorateWhitelist(String jsonString, List<String> white) {
        try {
            JsonNode node = JsonParser.parse(jsonString);
            recursiveWhitelistFilter(node, white);
            return node.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void recursiveWhitelistFilter(JsonNode node, List<String> wList) {
        if (node instanceof ObjectNode) {
            JsonNode deepcopyNode = node.deepCopy();
            Iterator<String> fields = deepcopyNode.fieldNames();
            while (fields.hasNext()) {
                String field = fields.next();
                if (!(wList.contains(field))) {
                    ((ObjectNode)node).remove(field);
                }else{
                    recursiveWhitelistFilter(node.get(field),wList);
                }
            }
        }
    }
}