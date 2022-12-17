package pl.put.poznan.jtools.logic;

import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileWriter {
    public static void write(String jsonString, Path filePath) {

        try {
            Files.writeString(filePath, jsonString);
        }
        catch (Exception e)
        {
            System.out.println("JsonFileWriter failed!");
        }
    }
}
