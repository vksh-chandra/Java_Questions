package DP;
import java.util.*;

public class DPSubMatrixWith1 {

	public static int solution(int[][] arr) {
		//write your code here
		int n = arr.length;
		int m = arr[0].length;
		int[][] dp = new int[n][m];
		
		for(int i=n-1; i>=0; i--){
		    for(int j=m-1; j>=0; j--){
		        if(arr[i][j]==0){
		            dp[i][j]=0;
		        }else{
		            if(i==n-1 && j==m-1){
		                dp[i][j]=arr[i][j];
		            }
		            
		            else if(i==n-1){
		                dp[i][j] = arr[i][j];
		            }else if(j==m-1){
		                dp[i][j] = arr[i][j];
		            }else{
		                
		                dp[i][j] = 1+ Math.min(dp[i][j+1], Math.min(dp[i+1][j+1], dp[i+1][j])); 
		                
		            }
		            
		        }
		    }
		}
		
		int max = 0;
		for(int i=0; i<n;i++){
		    for(int j=0; j<m;j++){
		        if(dp[i][j] >= max){
		            max = dp[i][j];
		        }
		    }
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
		scn.close();
	}

}
