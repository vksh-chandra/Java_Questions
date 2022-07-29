package Sorting;
import java.util.*;
public class CountingSort {
    public static int[] countingSort(int[] array, int n, int max){
        int[] count = new int[max+1];

        //fill array with 0's
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
          }
        
        //Store frequency of an element in count array
        for(int i=0;i<n; i++){
            count[array[i]]++;
        }

        //store cumulative sum of element in count array
        for(int i=1; i<=max;i++){
            count[i] += count[i-1];
        }

        int[] b = new int[n+1];
        for(int i=n-1;i>=0;i--){
            b[--count[array[i]]] = array[i];
        }

        for(int i=0;i<n;i++){
            array[i] = b[i];
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = src.nextInt();
        System.out.println("Enter "+n + " elemnt in array: ");
        int[] array = new int[n];
        int max =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
            if(array[i]>max){
                max = array[i];
            }
        }

        countingSort(array,n, max);
        System.out.println(Arrays.toString(array));
        src.close();
    }
}
