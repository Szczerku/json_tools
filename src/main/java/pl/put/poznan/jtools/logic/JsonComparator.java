package pl.put.poznan.jtools.logic;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Iterator;



public class JsonComparator {

    public static void Comparator(String jsonString, String jsonString2) {
        try {
            JsonParser parser = new JsonParser();
            JsonParser parserr = new JsonParser();
            JsonNode node = parser.parse(jsonString);
            JsonNode node2 = parserr.parse(jsonString2);
            recursivecompare(node, node2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void recursivecompare(JsonNode o1, JsonNode o2) {
        JsonNode deepcopyNode = o1.deepCopy();
        JsonNode deepcopyNode2 = o2.deepCopy();
        Iterator<String> fields = deepcopyNode.fieldNames();
        Iterator<String> fieldss = deepcopyNode2.fieldNames();
        while (fields.hasNext() && fieldss.hasNext()) {
            String field = fields.next();
            String fieldd = fieldss.next();
            if (field.equals(fieldd)) {
                System.out.println("");
                recursivecompare(o1.get(field), o2.get(fieldd));
            } else {
                System.out.println(field + " " + fieldd);
                recursivecompare(o1.get(field), o2.get(fieldd));
            }
        }
    }
}
