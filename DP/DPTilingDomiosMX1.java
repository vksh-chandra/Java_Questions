package DP;
import java.util.*;
public class DPTilingDomiosMX1 {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int m = src.nextInt();

        //tiles M X 1
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i<m){
                dp[i] = i;
            }else if(i==m){
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1]+dp[i-m];
            }
        }
        System.out.println(dp[n]);
        
        src.close();
    }
}
