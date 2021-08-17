package edu.lessons.hev_task;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> list;
        char ch = scanChar();

        ProcessFile processFile = new ProcessFile(ch);

        list = processFile.getResult();

        list.forEach(System.out::println);
    }

    private static char scanChar() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter letter!");
        char letter = scan.next().trim().charAt(0);

        return Character.isLetter(letter) ? letter : scanChar();
    }
}