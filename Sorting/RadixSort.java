package Sorting;
import java.util.*;
public class RadixSort {

    public static void countingSOrt(int[] array, int n, int p){
        
        int[] b = new int[n];
        int[] count = new int[10];
        for(int i=0;i<10;i++){
            count[i] =0;
        }

        for(int i=0;i<n;i++){
            count[(array[i]/p)%10]++;
        }

        for(int i=1;i<10;i++){
            count[i] += count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            b[--count[(array[i]/p)%10]] = array[i];
        }
        for(int i=0;i<n;i++){
            array[i] = b[i];
        }
    }

    public static void radixSort(int[] array, int n){
        int max = array[0];
        for(int i=1;i<n;i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        for(int p=1; max/p>0; p=p*10){
            countingSOrt(array, n, p);
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

        radixSort(array, n);
        System.out.println(Arrays.toString(array));
        src.close();
    }
}
