package Sorting;
import java.util.*;
public class SelectionSort {
    public static int[] selectionSort(int[] array, int n){
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(array[j]<array[min]){
                    min =j;
                }
            }
            if(min!=i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
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

        selectionSort(array, n);
        System.out.println(Arrays.toString(array));
        src.close();
    }
}
