package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

public class JsonWhitelist extends JsonDecorator{
    public final List<String> whitelist;
    private final Logger logger = LoggerFactory.getLogger(JsonWhitelist.class);
    public JsonWhitelist(JsonObjectInterface jsonObject, List<String> whitelist){
        super(jsonObject);
        this.whitelist = whitelist;
    }
    public String decorate() {
        return decorateWhitelist(super.decorate(), this.whitelist);
    }
    public String decorateWhitelist(String jsonString, List<String> white) {
        try {
            JsonParser parser = new JsonParser();
            JsonNode node = parser.parse(jsonString);
            recursiveWhitelistFilter(node, white);
            return node.toString();
        } catch (Exception e) {
            logger.error("decorateWhitelist failed!");
            e.printStackTrace();
            return "";
        }
    }

    public void recursiveWhitelistFilter(JsonNode node, List<String> wList) {
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