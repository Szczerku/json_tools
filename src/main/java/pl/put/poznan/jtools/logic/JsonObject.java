package pl.put.poznan.jtools.logic;

/***
 * Implementation of JsonObjectInterface.
 * Object to be decorated by using decorator design pattern
 */
public class JsonObject implements JsonObjectInterface{
    /***
     * Holds JSON text that is used for decoration
     */
    private final String jsonText;

    /***
     * Constructs JsonObject
     * @param jsonText text for decoration
     */
    public JsonObject(String jsonText) {
        this.jsonText = jsonText;
    }

    /***
     * The most simple decoration.
     * Does no decoration, returns original text
     * @return text for decoration
     */
    @Override
    public String decorate() {
        return jsonText;
    }
}
