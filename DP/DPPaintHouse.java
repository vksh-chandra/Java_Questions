package DP;
import java.util.*;

public class DPPaintHouse {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[][] array = new int[n][3];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                array[i][j] = src.nextInt();
            }
        }
        long[][] dp = new long[n][3];
        dp[0][0] = array[0][0];
        dp[0][1] = array[0][1];
        dp[0][2] = array[0][2];

        for(int i=1;i<array.length;i++){
            dp[i][0] = array[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = array[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = array[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        
        long min = dp[n-1][0];
        for(int i=1;i<3;i++){
            if(min>dp[n-1][i]){
                min = dp[n-1][i];
            }
        }
        System.out.println(min);
        src.close();
    }
}
