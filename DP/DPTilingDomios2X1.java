package DP;
import java.util.*;
public class DPTilingDomios2X1 {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        //int[] dp = new int[n+1];
        // dp[1] = 1;
        // dp[2] = 2;
        // for(int i=3;i<=n;i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        long[] dp = new long[n+1];
        
        for(int i=1; i<=n; i++){
            if(i==1){
                dp[i] = 1;
            }else if(i==2){
                dp[i] = 2;
            } 
            else{
                dp[i] = (dp[i-1]+dp[i-2])%1000000007;
            }
        }
        System.out.println(dp[n]);

        src.close();
    }
}
