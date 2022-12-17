package pl.put.poznan.jtools.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonBeautifierTest {

    static String projectRootDir = System.getProperty("user.dir");
    static String resoursesDir = "src/test/resources";
    static String examplesDir = "JsonExamples";
    static String minifiedExamplesDir = "JsonMinifiedExamples";

    @Test
    public void testBeautify() {
        Path minifiedJsonExample = Paths.get(projectRootDir, resoursesDir, minifiedExamplesDir, "minifiedexample1.json");
        String minifiedJsonString = JsonFileReader.read(minifiedJsonExample);
        String beautifiedJson = JsonBeautifier.beautify(minifiedJsonString);

        Path jsonExample = Paths.get(projectRootDir, resoursesDir, examplesDir, "example1.json");
        String JsonString = JsonFileReader.read(jsonExample);

        // System.out.println(beautifiedJson);

        // TODO: use Junit and TextCompare
        assertTrue(true);
    }
}
