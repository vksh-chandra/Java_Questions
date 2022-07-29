package DP;
import java.util.*;
public class DPClimbMinMove {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];
        Integer[] dp = new Integer[n+1];
        
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            if(array[i]>0){
                int min = Integer.MAX_VALUE;

                for(int j=1;j<=array[i] && i+j<dp.length;j++){
                    if(dp[i+j]!=null){
                        min = Math.min(min, dp[i+j]);
                    }
                }
                if(min != Integer.MAX_VALUE){
                    dp[i] = min+1;
                }
            }
        }
        System.out.println(dp[0]);


        src.close();
    }
}
