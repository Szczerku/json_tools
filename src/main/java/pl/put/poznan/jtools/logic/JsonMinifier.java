package pl.put.poznan.jtools.logic;

public class JsonMinifier extends JsonDecorator{
    public JsonMinifier(JsonObjectInterface jsonObject){
        super(jsonObject);
    }


    public String decorate() {
        return super.decorate() + decorateMinify();
    }
    public String decorateMinify(){
        return " minified";
    }
}
