package edu.lessons.hev_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProcessFile {
    private int max, temp;
    private Path path;
    private char ch;
    private List<String> result;

    public ProcessFile() {
        path = Path.of("src/edu/lessons/hev_task/hev_task.txt");
    }

    public ProcessFile(Path path) {
        this.path = path;
    }

    private List<String> stringProcessing(String dataFromFile, List<String> result) {
        temp = 0;

        for (String str : dataFromFile.split("[^\\w']+")) {
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

            temp = 0;
        }

        return result;
    }

    public List<String> getResult(char ch) throws IOException {
        this.max = 0;
        this.ch = ch;
        result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String arr;

            while ((arr = reader.readLine()) != null) {
                stringProcessing(arr, result);
            }
        } catch (IOException e) {
            throw new IOException("File reading error", e);
        }

        System.out.println("==== Max: " + max + " ====");
        return result;
    }
}
