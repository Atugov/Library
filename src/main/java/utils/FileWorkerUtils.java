package utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileWorkerUtils {
    public static void writeToFile(String path, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(path, true);
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
    }
}
