package Sorting;
import java.util.*;
public class InsertionSort {

    public static int[] insertionSort(int[] array, int n){
        for(int i=1;i<n;i++){
            int temp = array[i];
            int j = i-1;
            while(j>=0 && temp<array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
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

        insertionSort(array, n);
        System.out.println(Arrays.toString(array));
        src.close();
    }
}
