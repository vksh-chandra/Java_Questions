package DP;
import java.util.*;
public class DPCoinChangeComb {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }
        int amt = src.nextInt();
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=array[i];j<dp.length;j++){
                dp[j] += dp[j-array[i]];
            }
        }
        System.out.println(dp[amt]);

        src.close();
    }
}
