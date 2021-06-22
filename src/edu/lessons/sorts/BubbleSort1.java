package edu.lessons.sorts;

public class BubbleSort1 {

    public static void main(String[] args) {



    }

    private static int bubbleSort1(Integer[] arr){

        int temp = 0;
        int it = 0;

        for(int i = arr.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
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
