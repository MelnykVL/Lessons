package edu.lessons.sorts;

public class BubbleSort2 {

    public static void main(String[] args) {



    }

    private static int bubbleSort2(Integer[] arr){

        int temp = 0;
        int it = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){

                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                it++;
            }
            it++;
        }

        return it;

    }

}
