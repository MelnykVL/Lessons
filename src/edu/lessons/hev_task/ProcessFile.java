package edu.lessons.hev_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessFile {
    private int max, temp;
    private Path path;
    private char ch;
    private List<String> result;

    private final Logger LOGGER = Logger.getLogger(ProcessFile.class.getName());

    public ProcessFile() {
        path = Path.of("src/edu/lessons/hev_task/hev_task.txt");
    }

    public ProcessFile(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    private List<String> stringProcessing(String dataFromFile, List<String> result) {
        for (String str : dataFromFile.split("[^\\w']+")) {
            temp = 0;

            for (int i = 0; i < str.length(); i++) {
                if (Character.toLowerCase(ch) == Character.toLowerCase(str.charAt(i)))
                    temp++;
            }

            if (temp == 0) {
                continue;
            } else if (max < temp) {
                max = temp;
                result.clear();
                result.add(str);
            } else if (max == temp)
                result.add(str);
        }

        return result;
    }

    public List<String> getResult(char ch) {
        this.max = 0;
        this.ch = ch;
        result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String arr;

            while ((arr = reader.readLine()) != null) {
                stringProcessing(arr, result);
            }
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }

        System.out.println("==== Max: " + max + " ====");
        return result;
    }
}
