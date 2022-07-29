//You are required to print the number of binary strings of length n with no consecutive 0's.
package DP;
import java.util.*;
public class DPCountBinaryString {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        //binary ending with 0
        int[] dp0 = new int[n+1];
        //binary ending with 1
        int[] dp1 = new int[n+1];

        for(int i=0;i<dp0.length;i++){
            if(i==0){
                dp0[i] = 0;
                dp1[i] = 0;
            }
            else if(i==1){
                dp0[i] = 1;
                dp1[i] = 1;
            }
            else{
                //do zero sath m nai chyei too zero wala m bas wo lnge wo 1 s end krega
                //or 1 wale m sb jyega 0 or 1 ka kuki 1 eek sath aa skta haii
                dp1[i] = dp1[i-1]+ dp0[i-1];
                
                dp0[i] += dp1[i-1];
            }
        }
        System.out.println(dp0[n]+dp1[n]);
        src.close();
    }
}
