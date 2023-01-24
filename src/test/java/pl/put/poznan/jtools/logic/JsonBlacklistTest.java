package pl.put.poznan.jtools.logic;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JsonBlacklistTest {
    @Test
    public void testDecorate(){
        JsonObject jsonObject = mock(JsonObject.class);
        String jsonInString = "{\"widget\": {\"debug\": \"on\", \"window\": { \"title\": \"Sample Konfabulator Widget\" }}}";
        when(jsonObject.decorate()).thenReturn(jsonInString);
        List<String> blacklist = new ArrayList<String>();
        blacklist.add("window");
        JsonBlacklist jsonBlacklist = new JsonBlacklist(jsonObject, blacklist);
        String expectedString = "{\"widget\":{\"debug\":\"on\"}}";

        assertEquals(expectedString, jsonBlacklist.decorate());
    }
}