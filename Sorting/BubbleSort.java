package Sorting;

import java.util.*;
public class BubbleSort{

    public static int[] bubbleSort(int[] array, int n){
        for(int i=0;i<n;i++){
            int flag =0;
            for(int j=0;j<n-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag =1;
                }
            }
            if(flag==0){
                break;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = src.nextInt();
        System.out.println("Enter "+n + " elemnt in array: ");
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }

        bubbleSort(array, n);
        System.out.println(Arrays.toString(array));
        src.close();
    }
}
