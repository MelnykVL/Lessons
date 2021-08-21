package edu.lessons.hev_task;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProcessFile processFile = new ProcessFile();
        List<String> list;
        char ch;

        ch = scanChar();
        list = processFile.getResult(ch);
        list.forEach(System.out::println);

        ch = scanChar();
        list = processFile.getResult(ch);
        list.forEach(System.out::println);

        ch = scanChar();
        list = processFile.getResult(ch);
        list.forEach(System.out::println);
    }

    private static char scanChar() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter letter!");
        char letter = scan.next().trim().charAt(0);

        return Character.isLetter(letter) ? letter : scanChar();
    }
}