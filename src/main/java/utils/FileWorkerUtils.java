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
//    private void overwriteToFile (ActionEvent event) throws IOException {
//        String searchWord = scrfield.getText();
//        String changeWord = chngfield.getText();
//
//        StringBuilder sb = new StringBuilder();
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
//            String strLine;
//            while ((strLine = br.readLine()) != null) {
//                sb.append(strLine.replace(searchWord, changeWord)).append("\r\n");
//            }
//        }
//
//        try (FileWriter fileWriter = new FileWriter(file)) {
//            fileWriter.write(sb.toString());
//        }

    }

