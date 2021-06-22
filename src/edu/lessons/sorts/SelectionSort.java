package edu.lessons.sorts;

public class SelectionSort {

    public static void main(String[] args) {



    }

    private static int selectionSort(Integer[] arr){

        int temp = 0;
        int it = 0;

        for (int i = 0; i < arr.length; i++){
            temp = arr[i];
            for (int j = i; j < arr.length; j++){

                if (temp > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                it++;

            }
            it++;
        }

        return it;

    }

}
