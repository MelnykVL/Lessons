package edu.lessons.sorts;

import java.util.Arrays;

public class Shuffle {

    private static final int[] ARRAY = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {

        Arrays.stream(ARRAY).forEach(System.out::print);

        System.out.println();

        Arrays.stream(shuffle(ARRAY)).forEach(System.out::print);

        System.out.println();

        Arrays.stream(ARRAY).forEach(System.out::print);

    }

    public static int[] shuffle(int[] values){

        int[] arr = values.clone();
        int tempValue;
        int tempIndex;

        for(int i = 0; i < arr.length; i++){

            tempValue = arr[i];
            tempIndex = (int) (Math.random() * arr.length);

            arr[i] = arr[tempIndex];
            arr[tempIndex] = tempValue;

        }

        return arr;
    }

}
