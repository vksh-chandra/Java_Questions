package DP;
import java.util.*;

public class DPPermutation {

    // static int permute(int n, int k){
    //     int[][] p = new int[n+1][k+1];
        
    //     for(int i=0;i<=n;i++){
    //         for(int j=0; j<=Math.min(i, k); j++){
    //             if(j==0){
    //                 p[i][j] = 1;
    //             }
    //             else{
    //                 p[i][j] = p[i-1][j] + (j*p[i-1][j-1]);
    //             }
    //         }
    //     }
    //     return p[n][k];
    // }

    static int permute(int n, int k){
        int[] p = new int[n+1];
        p[0] = 1;

        for(int i=1; i<=n;i++){
            p[i] = i*p[i-1];
        }
        return p[n]/p[n-k];
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int k = src.nextInt();
        System.out.println("Permutation is: " +permute(n,k));

        src.close();
    }
}
