package pl.put.poznan.jtools.logic;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class JsonBlacklistTest {
    @Test
    public void testblacklisting(){
        String jsonInString = "{\"name\":\"mkyong\",\"age\":37,\"skills\":[\"java\",\"python\"]}";
        String blacklisted = JsonBlacklist.blacklisting(jsonInString, new String[]{"age","java"});
        System.out.println(blacklisted);
    }
}