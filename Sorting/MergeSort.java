package Sorting;
import java.util.*;
public class MergeSort {
    public static void merge(int[] array, int lb, int mid, int ub){
        int s1 = mid-lb+1;
        int s2 = ub-mid;
        int[] l = new int[s1];
        int[] r = new int[s2];

        for(int i=0;i<s1;i++){
            l[i] = array[i+lb];
        }
        for(int i=0;i<s1;i++){
            r[i] = array[i+mid+1];
        }
        int i=0, j=0;
        int k=lb;

        while(i<s1 && j<s2){
            if(l[i]<=r[j]){
                array[k++] = l[i++];
            }else{
                array[k++] = r[j++];
            }
        }
        while(i<s1){
            array[k++] = l[i++];
        }
        while(j<s2){
            array[k++] = r[j++];
        }
    }

    public static void mergeSort(int[] array,int lb, int ub){
        if(lb<ub){
            int mid = (lb+ub)/2;
            mergeSort(array, lb, mid);
            mergeSort(array, mid+1, ub);
            merge(array, lb, mid, ub);
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

        mergeSort(array,0, n);
        System.out.println(Arrays.toString(array));
        src.close();
    }
}
