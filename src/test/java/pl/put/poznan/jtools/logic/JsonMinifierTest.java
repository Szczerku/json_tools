package pl.put.poznan.jtools.logic;

import org.junit.jupiter.api.Test;
import pl.put.poznan.jtools.helper.ResourcePathHelper;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonMinifierTest {
    @Test
    public void testMinify() {
        Path beautifiedJsonExample = ResourcePathHelper.getJsonExampleFilePath("example1.json");
        String beautifiedJsonString = JsonFileReader.read(beautifiedJsonExample);
        String minifiedJsonString = JsonMinifier.minify(beautifiedJsonString);

        Path jsonExample = ResourcePathHelper.getMinifiedJsonExampleFilePath("minifiedexample1.json");
        String jsonString = JsonFileReader.read(jsonExample);

        assertEquals(minifiedJsonString, jsonString);
    }
}
