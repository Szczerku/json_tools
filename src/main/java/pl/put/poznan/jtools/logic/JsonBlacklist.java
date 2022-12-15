package pl.put.poznan.jtools.logic;

import java.util.List;

public class JsonBlacklist extends JsonDecorator {
    private final List<String> blacklist;
    public JsonBlacklist(JsonObjectInterface jsonObject, List<String> blacklist) {
        super(jsonObject);
        this.blacklist = blacklist;
    }

    public String decorate() {
        return super.decorate() + decorateBlacklist(blacklist);
    }

    public String decorateBlacklist(List<String> blacklist) {
        return " blacklisted with " + blacklist;
    }
}