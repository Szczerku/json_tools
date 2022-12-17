package pl.put.poznan.jtools.logic;

import java.util.List;

public class JsonWhitelist extends JsonDecorator{
    private final List<String> whitelist;
    public JsonWhitelist(JsonObjectInterface jsonObject, List<String> whitelist){
        super(jsonObject);
        this.whitelist = whitelist;
    }

    public String decorate() {
        return decorateWhitelist();
    }
    public String decorateWhitelist(){
        String jsonString = super.decorate();
        // TODO: implement whitelisting
        // can access whitelist here, example: whitelist.get(0);

        // TODO: replace this with properly filtered string
        return jsonString;
    }
}