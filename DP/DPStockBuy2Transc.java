package DP;
import java.util.*;
public class DPStockBuy2Transc {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }

        //from start of the graph
        int lwst = array[0];
        //proft if bought today
        int mpist = 0;
        int[] dp1 = new int[array.length];

        for(int i=1;i<n;i++){
            if(array[i]<lwst){
                lwst = array[i];
            }
            mpist = array[i] - lwst;

            if(mpist>dp1[i-1]){
                dp1[i] = mpist;
            }else{
                dp1[i] = dp1[i-1];
            }
        }

        //from end of the graph
        //profit if bought today and sell.
        int mpibt = 0;
        //maximun after today
        int maxat = array[array.length-1];
        int[] dp2 = new int[array.length];

        for(int i=array.length-2;i>=0;i--){
            if(maxat<array[i]){
                maxat = array[i];
            }

            mpibt = maxat- array[i];
            if(mpibt>dp2[i+1]){
                dp2[i] = mpibt;
            }else{
                dp2[i] = dp2[i+1];
            }
        }

        //overal profit
        int op=0;
        for(int i=0;i<array.length;i++){
            if(dp1[i]+dp2[i]>op){
                op = dp1[i]+dp2[i];
            }
        }
        System.out.println(op);

        src.close();

    }
}
