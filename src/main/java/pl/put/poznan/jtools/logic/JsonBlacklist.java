package pl.put.poznan.jtools.logic;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.*;



public class JsonBlacklist extends JsonDecorator {
    private final List<String> blacklist;

    public String decorate() {
        return decorateBlacklist(super.decorate(), this.blacklist);
    }

    public JsonBlacklist(JsonObjectInterface jsonObject, List<String> blacklist) {
        super(jsonObject);
        this.blacklist = blacklist;
    }

    public String decorateBlacklist(String jsonString, List<String> black) {
        try {
            JsonNode node = JsonParser.parse(jsonString);
            recursiveBlacklistFilter(node, black);
            return node.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void recursiveBlacklistFilter(JsonNode node, List<String> bList) {
        if (node instanceof ObjectNode) {
            JsonNode deepcopyNode = node.deepCopy();
            Iterator<String> fields = deepcopyNode.fieldNames();
            while (fields.hasNext()) {
                String field = fields.next();
                if (bList.contains(field)) {
                    ((ObjectNode)node).remove(field);
                }else{
                    recursiveBlacklistFilter(node.get(field),bList);
                }
            }
        }
    }
}
