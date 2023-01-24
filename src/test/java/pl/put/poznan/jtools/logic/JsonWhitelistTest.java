package pl.put.poznan.jtools.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class JsonWhitelistTest {
    @Test
    public void testDecorate(){
        JsonObject jsonObject = mock(JsonObject.class);
        String jsonInString = "{\"widget\": {\"debug\": \"on\", \"window\": { \"title\": \"Sample Konfabulator Widget\" }}}";
        when(jsonObject.decorate()).thenReturn(jsonInString);
        ArrayList<String> whitelist = new ArrayList<>();
        whitelist.add("abc");
        JsonWhitelist jsonWhitelist = new JsonWhitelist(jsonObject, whitelist);
        String expectedString = "{}";

        assertEquals(expectedString, jsonWhitelist.decorate());
    }
}