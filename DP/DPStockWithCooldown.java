package DP;
import java.util.*;
public class DPStockWithCooldown {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];

        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
        }
        //old buy state profit on day 1
        int obsp = -array[0];
        //old sell state profit on dayy 1
        int ossp= 0;
        //old cool down proft after sell on day 1
        int ocsp = 0;

        for(int i=1;i<n;i++){
            //new buy state profit on day i
            int nbsp =0;
            //new sell state profit on dayy i
            int nssp =0;
            //new cool down proft after sell on day i
            int ncsp =0;

            if(ocsp-array[i]>obsp){
                nbsp = ocsp - array[i];
            }else{
                nbsp = obsp;
            }

            if(obsp+array[i]>ossp){
                nssp = obsp+array[i];
            }else{
                nssp = ossp;
            }

            if(ossp>ocsp){
                ncsp = ossp;
            }else{
                ncsp = ocsp;
            }

            ossp = nssp;
            ocsp = ncsp;
            obsp = nbsp;
        }
        System.out.println(ossp);
        src.close();
    }
}
