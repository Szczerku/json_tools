package pl.put.poznan.jtools.logic;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.*;



public class JsonBlacklist extends JsonDecorator {
    private final String[] blacklist;
    public String decorate() {
        return blacklisting(super.decorate(), this.blacklist);
    }

    public JsonBlacklist(JsonObjectInterface jsonObject, String[] blacklist) {
        super(jsonObject);
        this.blacklist = blacklist;
    }

    public static String blacklisting(String jsonString, String[] black) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            for (JsonNode node : jsonNode) {
                ((ObjectNode) node).remove(Arrays.asList(black));
            }

            return jsonNode.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return new String();
        }
    }

    public String decorateBlacklist(List<String> blacklist) {
        return " blacklisted with " + blacklist;
    }
}