package pl.put.poznan.jtools.helper;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourcePathHelper {
    static String projectRootDir = System.getProperty("user.dir");
    static String resoursesDir = "src/test/resources";
    static String examplesDir = "JsonExamples";
    static String minifiedExamplesDir = "JsonMinifiedExamples";

    public static Path getMinifiedJsonExampleFilePath(String fileName) {
        return Paths.get(projectRootDir, resoursesDir, minifiedExamplesDir, fileName);
    }

    public static Path getJsonExampleFilePath(String fileName) {
        return Paths.get(projectRootDir, resoursesDir, examplesDir, fileName);
    }
}
