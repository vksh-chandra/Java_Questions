package DP;
import java.util.*;

public class DPBinomialCoeff {
    static int bioCoficent(int n, int k){
        int[][] c = new int[n+1][k+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0; j<=Math.min(i, k); j++){
                if(j==0 || j==i){
                    c[i][j] = 1;
                }
                else{
                    c[i][j] = c[i-1][j-1] + c[i-1][j];
                 }
            }
        }
        return c[n][k];
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int k = src.nextInt();
        System.out.println(bioCoficent(n, k));
        src.close();
    }
}
