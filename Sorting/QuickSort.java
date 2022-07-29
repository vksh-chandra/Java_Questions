package Sorting;
import java.util.*;
public class QuickSort {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = low;
        int j = low;
        while(i<=high){
            if(arr[i]<=pivot){
                swap(arr, i, j);
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j-1;
    }

    static void quickSort(int[] array, int lb, int ub){
        if(lb<ub){
            int loc = partition(array, lb, ub);
            quickSort(array, lb, loc-1);
            quickSort(array, loc+1, ub);
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

        quickSort(array,0, n-1);
        System.out.println(Arrays.toString(array));
        src.close();
    }
}
