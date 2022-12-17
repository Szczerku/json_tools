package pl.put.poznan.jtools.logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileWriter {
    public static void write(String jsonString, Path filePath) throws IOException {

        Files.writeString(filePath, jsonString);
    }
}
