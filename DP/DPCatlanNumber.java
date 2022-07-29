package DP;
import java.util.*;

public class DPCatlanNumber {
    static int catlanNum(int n){
        int[] array = new int[n+2];
        array[0] = 1;
        array[1] = 1;
        for(int i=2; i<=n;i++){
            array[i] = 0;
            for(int j= 0; j<i; j++){
                array[i] += array[j]*array[i-j-1];
            }
         }
         return array[n];
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        System.out.println(catlanNum(n));
        src.close();

    }
}
