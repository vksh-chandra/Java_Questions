package DP;
import java.util.*;
public class DPCoinChangePer {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] amt = new int[n];
        for(int i=0;i<n;i++){
            amt[i] = src.nextInt();
        }
        int tot = src.nextInt();
        int[] dp = new int[tot+1];
        dp[0] =1;
        for(int i=1;i<dp.length;i++){
            for(int j = 0;j<n;j++){
                int val = amt[j];
                if(i>=val){
                    dp[i] += dp[i-val];
                }
            }
        }
        System.out.println(dp[tot]);

        src.close();
    }
}
