package pl.put.poznan.jtools.logic;

public class JsonObject implements JsonObjectInterface{

    private final String jsonText;

    public JsonObject(String jsonText) {
        this.jsonText = jsonText;
    }
    @Override
    public String decorate() {
        return jsonText;
    }
}
