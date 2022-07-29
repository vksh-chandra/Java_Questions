package DP;
import java.util.Scanner;

public class DPMinCostMazeTravel {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int m = src.nextInt();
        int[][] array = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j] = src.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1; j>=0;j--){
                if(i==n-1 && j==m-1){
                    dp[i][j] = array[i][j];
                }
                else if(i==n-1){
                    dp[i][j] = array[i][j] + dp[i][j+1];
                }
                else if(j==m-1){
                    dp[i][j] = array[i][j] + dp[i+1][j];
                }
                else{
                        dp[i][j] = array[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);
        src.close();
    }
}
