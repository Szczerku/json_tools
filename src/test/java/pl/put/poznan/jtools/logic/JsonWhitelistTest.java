package pl.put.poznan.jtools.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonWhitelistTest {
    @Test
    public void testprimitivewhitelisting(){
        String jsonInString = "{\"name\":\"mkyong\",\"age\":twelve,\"skills\":[\"java\",\"python\"]}";
        ArrayList <String> example = new ArrayList<>();
        example.add("name");
        example.add("age");
        example.add("java");
        String whitelisted = JsonWhitelist.decorateWhitelist(jsonInString, example);
        assertEquals("nameagejava",whitelisted);
    }
}