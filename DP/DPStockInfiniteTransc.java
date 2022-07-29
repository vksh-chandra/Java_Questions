package DP;
import java.util.*;
public class DPStockInfiniteTransc {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] price = new int[n];
        for(int i=0;i<n;i++){
            price[i] = src.nextInt();
        }

        int profit = 0;
        int buy = price[0];
        int sell = price[0];

        for(int i=1;i<n;i++){
            if(price[i]>price[i-1]){
                sell = price[i];
            }else{
                profit =profit+(sell-buy);
                sell = price[i];
                buy = price[i]; 
            }
        }
        //for last stokes. After the loop 
        profit = profit+(sell-buy);
        System.out.println(profit);
        src.close();
    }
}
