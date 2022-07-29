package DP;

import java.io.*;
import java.util.*;

public class PartitionIntoSubset {
        
    public static long partitionKSubset(int n, int k) {
        // write your code here
        long[][] dp = new long[k+1][n+1];

        for(int i=0;i<=k;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j] =0;
                }
                else if(i==1){
                    dp[i][j] = 1;
                }
                else if(i>j){
                    dp[i][j] = 0;
                }
                else if(i==j){
                    dp[i][j] =1;
                }
                else{
                    dp[i][j] = i*dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        return dp[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}