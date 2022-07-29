package DP;
import java.util.*;
public class DPStockWithFee {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }
        int fees = src.nextInt();

        //old bought state profit of day 1
        int obsp = -array[0];
        //old sold state profit on day 1
        int ossp=0;

        for(int i=1;i<n;i++){
            //new bought state profit on day i
            int nbsp =0;
            //new sold state proft on day i
            int nssp =0;

            if(ossp-array[i]>obsp){
                nbsp = ossp-array[i];
            }else{
                nbsp = obsp;
            }

            if(array[i]+obsp-fees>ossp){
                nssp = array[i]+obsp-fees;
            }else
            {
                nssp = ossp;
            }
            ossp = nssp;
            obsp = nbsp;
        }
        System.out.println(ossp);
        src.close();
    }
}
