package DP;
import java.util.*;
public class DPClimbVarSta {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }

        int[] dp = new int[n+1];
        dp[n] =1;
        for(int i=n-1;i>=0;i--){
            for(int j=1; j<=array[i] && i+j<=n; j++){
                dp[i] += dp[i+j];
                
            }
        }
        System.out.println(dp[0]);

        src.close();
    }
}
