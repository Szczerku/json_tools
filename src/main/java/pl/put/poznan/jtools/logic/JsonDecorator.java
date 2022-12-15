package pl.put.poznan.jtools.logic;

public abstract class JsonDecorator implements JsonObjectInterface{
    private final JsonObjectInterface jsonObject;

    public JsonDecorator(JsonObjectInterface jsonObject){
        this.jsonObject=jsonObject;
    }

    @Override
    public String decorate() {
        return this.jsonObject.decorate();
    }
}
