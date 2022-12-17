package pl.put.poznan.jtools.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class JsonBeautifierTest {
    @Test
    public void testBeautify() {
        Path exampleJson = Path.of("todo");
        String stringJson = JsonFileReader.read(exampleJson);
        String beautifiedJson = JsonBeautifier.beautify(stringJson);

        Path exampleJsonBeautified = Path.of("todo");
        JsonFileWriter.write(beautifiedJson, exampleJsonBeautified);

        // TODO: use Junit
        assertTrue(true);
    }
}
