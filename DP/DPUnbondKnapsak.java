package DP;
import java.util.*;

public class DPUnbondKnapsak {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];

        for(int i=0;i<n;i++){
            val[i] = src.nextInt();
        }

        for(int i=0;i<n;i++){
            wt[i] = src.nextInt();
        }
        
        int tar = src.nextInt();
        int[] dp = new int[tar+1];
        dp[0] =0;

        //Y COMBINATION WALA STYLE HAI... PERMUTATION WALA S V FARAK NAI PRTA KUKI ITEM TO SAME SELECT KRNGE
        for(int i=0;i<n;i++){
            for(int j=1;j<dp.length;j++){
                if(j>=wt[i]){
                    dp[j] = Math.max(val[i]+ dp[j-wt[i]], dp[j]);
                }
            }
        }
        System.out.println(dp[tar]);
        src.close();

    }
}
