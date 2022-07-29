package Sorting;
import java.util.*;
public class HeapSort {
    public static void heapify(int[] array, int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && array[left]>array[largest]){
            largest = left;
        }
        if(right<n && array[right]> array[largest]){
            largest = right;
        }
        if(largest!=i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    } 

    public static void heapSort(int[] array, int n){

        for(int i=n/2-1;i>=0;i--){
            heapify(array, n, i);
        }

        for(int i=n-1;i>=0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, i, 0);
        }
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

        heapSort(array, n);
        System.out.println(Arrays.toString(array));
        src.close();
    }
}
