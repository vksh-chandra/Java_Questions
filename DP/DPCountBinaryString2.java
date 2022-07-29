package DP;
//You are required to print the number of binary strings of length n with no consecutive 1's.
import java.util.*;

public class DPCountBinaryString2 {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        
        System.out.println(countStrings(n));
        src.close();
    }

    static long m = 1000000007;
    public static long countStrings(int n) {
        // code here
        if(n==0){
            return 0;
        }
        
        long c0 = 1;
        long c1 = 1;
        for(int i=2; i<=n; i++){
            long nc0 = (c0+c1)%m;
            c1 = c0;
            c0 = nc0;
        }
        
        return (c0+c1)%m;
    }
}
