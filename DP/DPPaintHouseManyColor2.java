package DP;
import java.util.*;
public class DPPaintHouseManyColor2 {
    public static void main(String[] args) {
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
        long least = Long.MAX_VALUE;
        long sleast = Long.MAX_VALUE;

        //METHOD TO GET LEAST AND SECOND LEAST NUMBERS.
        for(int i=0;i<k;i++){
            dp[0][i] = array[0][i];

            if(array[0][i]<= least){
                sleast = least;
                least = array[0][i];
            }else if(array[0][i]<=sleast){
                sleast = array[0][i];
            }
        }

        for(int i=1;i<n;i++){
            long newLeast = Long.MAX_VALUE;
            long newSleast = Long.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(least == dp[i-1][j]){
                    dp[i][j] = array[i][j] + sleast;
                }else{
                    dp[i][j] = array[i][j] + least;
                }
                if(dp[i][j]<= newLeast){
                    newSleast = newLeast;
                    newLeast = dp[i][j];
                }else if(dp[i][j]<=newSleast){
                    newSleast = dp[i][j];
                }
                least = newLeast;
                sleast = newSleast;
            }  
        }
        
        System.out.println(least);
        src.close();
    }
}
