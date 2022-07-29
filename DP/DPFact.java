package DP;
import java.util.*;
public class DPFact {
    static int fact(int n){
        int[] fac = new int[n+1];
        fac[0] = 1;
        for(int i=1;i<=n;i++){
            fac[i] = fac[i-1]*i;
        }
        return fac[n];
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        System.out.println("Factorial of "+n+" is : " +fact(n));
        src.close();
    }
}
