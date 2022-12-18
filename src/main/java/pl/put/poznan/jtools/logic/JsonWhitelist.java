package pl.put.poznan.jtools.logic;

import java.util.List;

public class JsonWhitelist extends JsonDecorator{
    public final List<String> whitelist;
    public JsonWhitelist(JsonObjectInterface jsonObject, List<String> whitelist){
        super(jsonObject);
        this.whitelist = whitelist;
    }
    public String decorate() {
        return decorateWhitelist(super.decorate(), this.whitelist);
    }
    public static String decorateWhitelist(String jsonString, List<String> white){
        // TODO: implement whitelisting
        // can access whitelist here, example: whitelist.get(0);
        String[]arr = new String [white.size()];
        //Converting List to Array
        white.toArray(arr);
        for (int i=0; i < arr.length; i++){
            if(jsonString.contains(arr[i])) {
                jsonString = jsonString.replaceAll(arr[i], Integer.toString(i));
            }
        }
        jsonString = jsonString.replaceAll("[^0-9]","");
        for (int j=0; j < arr.length; j++){
            jsonString = jsonString.replaceAll(Integer.toString(j),arr[j]);
        }
        // TODO: replace this with properly filtered string
        return jsonString;
    }
}