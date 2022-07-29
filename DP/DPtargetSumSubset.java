package DP;
import java.util.*;

public class DPtargetSumSubset {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }
        int tar = src.nextInt();
        boolean val = targetSum(array,n, tar);
        System.out.println(val);

        src.close();
    }

    public static boolean targetSum(int[] array,int n, int tar){
        //int len = array.length;
        boolean[][] dp = new boolean[n+1][tar+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                else if(j==0){
                    dp[i][j] = true;
                }
                else{
                    if(dp[i-1][j]==true){
                        dp[i][j] = true;
                    }else{
                        int val = array[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val]==true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[n][tar];
    }
}
