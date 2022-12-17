package pl.put.poznan.jtools.logic;

import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileReader {
    public static String read(Path filePath) {
        // TODO: ensure file is a JSON file
        try {
            return Files.readString(filePath);
        }
        catch (Exception e) {
            // TODO: exception handling
            System.out.println("JsonFileReader failed!");
            return new String();
        }
    }
}
