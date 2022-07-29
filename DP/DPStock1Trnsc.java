package DP;
import java.util.*;
public class DPStock1Trnsc {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] price = new int[n];
        for(int i=0;i<n;i++){
            price[i] = src.nextInt();
        }

        int lsf = Integer.MAX_VALUE;
        int profit = 0;
        int pist = 0;

        for(int i=0;i<n;i++){
            if(price[i]<lsf){
                lsf = price[i];
            }
            pist = price[i]-lsf;

            if(pist>profit){
                profit = pist;
            }
        }
        System.out.println(profit);
        src.close();
    }
}
