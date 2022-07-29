package DP;
import java.util.*;

public class DPPaintFence {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int k = src.nextInt();
        if(n==1){
            System.out.println(k);
        }

        //sm = in how many ways we can paint upto ith fence such that not more than two consecutive fence have the same color
                // but last two fence have same color
        int sm = 0;

        //diff = in how many ways we can paint upto ith fence such that not more than two consecutive fence have the same color
                // and last two fence have different color
        int diff = 0;
        int tot =0;
        for(int i=2;i<=n;i++){
            int nsm, ndiff;
            if(i==2){
                nsm = k;
                ndiff = k*(k-1);

            }else{
                nsm = diff;
                ndiff = tot*(k-1);
            }
            sm = nsm;
            diff = ndiff;
            tot = sm+diff;   
        }
        System.out.println(tot);
        src.close();
    }
}
