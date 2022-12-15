package pl.put.poznan.jtools.logic;

public class JsonBeautifier extends JsonDecorator{
    public JsonBeautifier(JsonObjectInterface jsonObject){
        super(jsonObject);
    }

    public String decorate() {
        return super.decorate() + decorateBeautify();
    }
    public String decorateBeautify(){
        return " beautified";
    }
}
