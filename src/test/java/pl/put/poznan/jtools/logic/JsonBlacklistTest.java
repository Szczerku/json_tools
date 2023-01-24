package pl.put.poznan.jtools.logic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JsonBlacklistTest {

    private ArrayList<String> blacklist;

    @BeforeEach
    public void setUp() {
        blacklist = new ArrayList<String>();
    }

    @Test
    public void testDecorate1(){
        JsonObject jsonObject = mock(JsonObject.class);
        String jsonInString = "{\"widget\": {\"debug\": \"on\", \"window\": { \"title\": \"Sample Konfabulator Widget\" }}}";
        when(jsonObject.decorate()).thenReturn(jsonInString);

        blacklist.add("window");

        JsonBlacklist jsonBlacklist = new JsonBlacklist(jsonObject, blacklist);
        String expectedString = "{\"widget\":{\"debug\":\"on\"}}";

        assertEquals(expectedString, jsonBlacklist.decorate());
    }

    @Test
    public void testDecorate2(){
        JsonObject jsonObject = mock(JsonObject.class);
        String jsonInString = "{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}";
        when(jsonObject.decorate()).thenReturn(jsonInString);

        blacklist.add("size");

        JsonBlacklist jsonBlacklist = new JsonBlacklist(jsonObject, blacklist);
        String expectedString = "{\"fruit\":\"Apple\",\"color\":\"Red\"}";

        assertEquals(expectedString, jsonBlacklist.decorate());
    }

    @Test
    public void testDecorate3(){
        JsonObject jsonObject = mock(JsonObject.class);
        String jsonInString = "{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\",\"image\":{\"url\":\"images/0001.jpg\",\"width\":200,\"height\":200},\"thumbnail\":{\"url\":\"images/thumbnails/0001.jpg\",\"width\":32,\"height\":32}}";
        when(jsonObject.decorate()).thenReturn(jsonInString);

        blacklist.add("name");
        blacklist.add("width");

        JsonBlacklist jsonBlacklist = new JsonBlacklist(jsonObject, blacklist);
        String expectedString = "{\"id\":\"0001\",\"type\":\"donut\",\"image\":{\"url\":\"images/0001.jpg\",\"height\":200},\"thumbnail\":{\"url\":\"images/thumbnails/0001.jpg\",\"height\":32}}";

        assertEquals(expectedString, jsonBlacklist.decorate());
    }
}