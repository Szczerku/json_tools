package pl.put.poznan.jtools.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileWriter {
    Logger logger = LoggerFactory.getLogger(JsonFileReader.class);
    public void write(String jsonString, Path filePath) {

        try {
            Files.writeString(filePath, jsonString);
        }
        catch (Exception e)
        {
            logger.error("JsonFileWriter failed!");
        }
    }
}
