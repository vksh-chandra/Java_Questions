package DP;
import java.io.*;
import java.util.*;

public class DPUnboundedKnapsack {

	public static void main(String[] args) throws Exception {
			Scanner src = new Scanner(System.in);
			int n = src.nextInt();
			int[] val = new int[n];
			int[] wt = new int[n];
			for(int i=0; i<n; i++){
				val[i] = src.nextInt();
			}
			for(int i=0; i<n; i++){
				wt[i] = src.nextInt();
			}

			int w = src.nextInt();
			System.out.println(unBounded(w, wt, val));
            src.close();
		}

		public static int unBounded(int W, int[] wt, int[] val){
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=W; j++){
                if(i==0 || j==0){
                     dp[i][j] = 0;
                }else{
                    int w = wt[i-1];
                    if(j-w<0){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j-w]+val[i-1], Math.max(dp[i-1][j], dp[i][j-w]+val[i-1]));
                    }
                 }
             }
         }
         return dp[n][W];
    }
}
