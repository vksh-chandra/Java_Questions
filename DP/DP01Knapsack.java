package DP;

import java.util.*;
public class DP01Knapsack {
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

        int[][] dp = new int[n+1][tar+1];
        //box meaning -> agr eek box use kie uska value max hga ya nai krnge uska
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else{
                    int x = wt[i-1];
                    if(j>=x){
                        dp[i][j] = Math.max(val[i-1]+dp[i-1][j-x], dp[i-1][j]);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);

        src.close();
    }
}
