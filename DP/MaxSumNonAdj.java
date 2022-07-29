package DP;
import java.util.*;
public class MaxSumNonAdj {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }
        int inc = array[0];
        int exc = 0;
        for(int i=1;i<n;i++){
            int newInc = exc + array[i];
            int newExc = Math.max(inc, exc);
            inc = newInc;
            exc = newExc;
        }
        System.out.println(Math.max(inc, exc));
        src.close();
    }
}
