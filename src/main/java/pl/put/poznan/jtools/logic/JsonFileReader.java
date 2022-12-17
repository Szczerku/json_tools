package pl.put.poznan.jtools.logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileReader {
    public static String read(String filePath) throws IOException {
        Path fp = Path.of(filePath);
        // TODO: ensure file is a JSON file
        return Files.readString(fp);
    }
}
