package DP;
import java.util.*;

public class DPClimbStair {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int cp = countStair(n);
        System.out.println(cp);
        src.close();
    }
    
    static int countStair(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
         
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1];
            }
            else if(i==2){
                dp[i] = dp[i-1]+dp[i-2];
            }
            else{
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }
}
