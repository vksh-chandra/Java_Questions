package DP;
import java.util.*;

public class DPPrintPathMinJump {

    static class Pair{
        int i;
        int s;
        int j;
        String psf;
        Pair(int i, int s, int j, String psf){
            //index 
            this.i = i;
            //size of jump given in array
            this.s = s;
            //jumps happend in dp 
            this.j = j;
            this.psf = psf;
        }
    }

    public static void Solution(int[] array){

        int len = array.length;
        Integer[] dp = new Integer[len];
        dp[len-1] = 0;
        for(int i=len-2; i>=0; i--){
            int paths = array[i];
            int min = Integer.MAX_VALUE;

            for(int j=1; j<=paths && j+i<array.length; j++){
                if(dp[i+j]!=null && dp[i+j] <min){
                    min = dp[i+j];
                }
            }
            
            if(min != Integer.MAX_VALUE){
                dp[i]= min+1;
            }
        }

        System.out.println(dp[0]);

        //using BFS for printing paths 
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, array[0], dp[0], 0+""));
        while(queue.size()>0){
            Pair rem = queue.remove();

            if(rem.j==0){
                System.out.println(rem.psf+" .");
            }

            for(int j=1; j<=rem.s && rem.i+j<array.length; j++){
                int ci = rem.i + j;
                if(dp[ci]!=null && dp[ci] == rem.j-1){
                    queue.add(new Pair(ci, array[ci], dp[ci], rem.psf+" -> "+ci));
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();

    }
}
