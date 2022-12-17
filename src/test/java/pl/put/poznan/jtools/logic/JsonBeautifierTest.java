package pl.put.poznan.jtools.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.put.poznan.jtools.helper.ResourcePathHelper;

import java.nio.file.Path;

public class JsonBeautifierTest {
    @Test
    public void testBeautify() {
        Path minifiedJsonExample = ResourcePathHelper.getMinifiedJsonExampleFilePath("minifiedexample1.json");
        String minifiedJsonString = JsonFileReader.read(minifiedJsonExample);
        String beautifiedJsonString = JsonBeautifier.beautify(minifiedJsonString);

        Path jsonExample = ResourcePathHelper.getJsonExampleFilePath("example1.json");
        String jsonString = JsonFileReader.read(jsonExample)
                .replace(": ", " : ")
                .replace("[", "[ ")
                .replace("]", " ]"); // different formatting

        assertEquals(beautifiedJsonString, jsonString);
    }
}
