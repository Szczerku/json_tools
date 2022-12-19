package pl.put.poznan.jtools.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileReader {
    Logger logger = LoggerFactory.getLogger(JsonFileReader.class);
    public String read(Path filePath) {
        // TODO: ensure file is a JSON file
        try {
            return Files.readString(filePath);
        }
        catch (Exception e) {
            logger.error("JsonFileReader failed!");
            return new String();
        }
    }
}
