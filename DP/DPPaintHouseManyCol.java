package DP;

import java.util.*;

public class DPPaintHouseManyCol{

    public static void main(String[] args) throws Exception {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int k = src.nextInt();
        int[][] array = new int[n][k];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                array[i][j] = src.nextInt();
            }
        }
        long[][] dp = new long[n][k];
        for(int i=0;i<k;i++){
            dp[0][i] = array[0][i];
        }

        for(int i=1;i<array.length;i++){
            for(int j=0;j<k;j++){
                dp[i][j] = array[i][j] + getMin(dp[i-1], j);
            }  
        }
        
        
        long min = dp[n-1][0];
        for(int i=1;i<k;i++){
            if(min>dp[n-1][i]){
                min = dp[n-1][i];
            }
        }
        System.out.println(min);
        src.close();
    }
    static long getMin(long[] dp, int j){
        long min = Long.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            if(i==j){
                continue;
            }else if(min>dp[i]){
                min = dp[i];
            }
        }
        return min;

    }
}