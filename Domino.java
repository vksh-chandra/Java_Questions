import java.util.*;
public class Domino {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int m = src.nextInt();
        int[][] array = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;i<m;j++){
                array[i][j] = src.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        for(int j=m-1; j>=0;j--){
            for(int i=n-1;i>=0;i--){
                if(j==m-1){
                    dp[i][j] = array[i][j];
                }
                else if(i==0){
                    dp[i][j] =array[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }
                else if(i==n-1){
                    dp[i][j] = array[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }
                else{
                        dp[i][j] = array[i][j] + Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]));
                }
            }
        }
        int max = dp[0][0];
        for(int i=0;i<n;i++){
            if(dp[i][0]>max){
                max = dp[i][0];
            } 
        }
        System.out.println(max);

        src.close();

    }
}
