package DP;
import java.util.*;

public class DpFib {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        DpFib fi = new DpFib();

        int res = fi.fib(n);

        System.out.println(res);
        src.close();
    }
    int fib(int n){
        int[] f = new int[n+2];
        f[0] = 0;
        f[1] = 1;

        for(int i=2; i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
