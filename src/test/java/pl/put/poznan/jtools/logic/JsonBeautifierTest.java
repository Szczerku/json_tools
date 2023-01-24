package pl.put.poznan.jtools.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.put.poznan.jtools.helper.ResourcePathHelper;

import java.nio.file.Path;

public class JsonBeautifierTest {
    @Test
    public void testDecorate() {
        Path minifiedJsonExample = ResourcePathHelper.getMinifiedJsonExampleFilePath("minifiedexample1.json");
        JsonFileReader fileReader = new JsonFileReader();
        String minifiedJsonString = fileReader.read(minifiedJsonExample);
        JsonObjectInterface jsonObject = new JsonBeautifier(new JsonObject(minifiedJsonString));
        String beautifiedJsonString = jsonObject.decorate();

        Path jsonExample = ResourcePathHelper.getJsonExampleFilePath("example1.json");
        String jsonString = fileReader.read(jsonExample)
                .replace(": ", " : ")
                .replace("[", "[ ")
                .replace("]", " ]"); // different formatting

        assertEquals(beautifiedJsonString, jsonString);

        assertEquals(
                new JsonBeautifier(
                        new JsonMinifier(
                                new JsonBeautifier(
                                        new JsonObject(minifiedJsonString)))).decorate(), jsonString);
    }

}
