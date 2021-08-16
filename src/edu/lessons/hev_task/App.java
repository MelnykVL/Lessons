package edu.lessons.hev_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    static final Path path = Path.of("src/edu/lessons/hev_task/hev_task.txt");

    public static void main(String[] args) throws IOException {
        List<String> list;
        char ch;

        ch = scanChar();
        list = readFile(path);
        list = getResult(list, ch);

        list.forEach(System.out::println);
    }

    private static List<String> getResult(List<String> dataFromFile, char ch) {
        List<String> result = new ArrayList<>();
        int max = 0, temp = 0;

        for (String str : dataFromFile) {
            for (int i = 0; i < str.length(); i++) {
                if (ch == str.toLowerCase().charAt(i))
                    temp++;
            }

            if (temp == 0) {
                continue;
            }else if (max < temp) {
                max = temp;
                result.clear();
                result.add(str);
            } else if (max == temp)
                result.add(str);

            temp = 0;
        }

        return result;
    }

    private static char scanChar() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter letter!");
        char letter = scan.next().trim().charAt(0);

        return Character.isLetter(letter) ? letter : scanChar();
    }

    private static List<String> readFile(Path path) throws IOException {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String arr;

            while ((arr = reader.readLine()) != null)
                list.addAll(Arrays.asList(arr.split("[^\\w']+")));
        } catch (IOException e) {
            throw new IOException("File reading error", e);
        }

        return list;
    }
}
