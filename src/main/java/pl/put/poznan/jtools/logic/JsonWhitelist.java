package pl.put.poznan.jtools.logic;

import java.util.List;

public class JsonWhitelist extends JsonDecorator{
    private final List<String> whitelist;
    public JsonWhitelist(JsonObjectInterface jsonObject, List<String> whitelist){
        super(jsonObject);
        this.whitelist = whitelist;
    }

    public String decorate() {
        return super.decorate() + decorateWhitelist(whitelist);
    }
    public String decorateWhitelist(List<String> whitelist){
        return " whitelisted with " + whitelist;
    }
}