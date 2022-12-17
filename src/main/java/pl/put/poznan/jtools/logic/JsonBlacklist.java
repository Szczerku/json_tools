package pl.put.poznan.jtools.logic;

import java.util.List;

public class JsonBlacklist extends JsonDecorator {
    private final List<String> blacklist;
    public JsonBlacklist(JsonObjectInterface jsonObject, List<String> blacklist) {
        super(jsonObject);
        this.blacklist = blacklist;
    }

    public String decorate() { return decorateBlacklist(); }

    public String decorateBlacklist() {
        String jsonString = super.decorate();
        // TODO: implement blacklisting
        // can access whitelist here, example: blacklist.get(0);

        // TODO: replace this with properly filtered string
        return jsonString;
    }
}