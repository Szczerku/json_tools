package pl.put.poznan.jtools.logic;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;



public class JsonBlacklist extends JsonDecorator {
    private final List<String> blacklist;
    private final Logger logger = LoggerFactory.getLogger(JsonBlacklist.class);

    public String decorate() {
        return decorateBlacklist(super.decorate(), this.blacklist);
    }

    public JsonBlacklist(JsonObjectInterface jsonObject, List<String> blacklist) {
        super(jsonObject);
        this.blacklist = blacklist;
    }

    public String decorateBlacklist(String jsonString, List<String> black) {
        try {
            JsonParser parser = new JsonParser();
            JsonNode node = parser.parse(jsonString);
            recursiveBlacklistFilter(node, black);
            return node.toString();
        } catch (Exception e) {
            logger.error("decorateBlacklist failed");
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
