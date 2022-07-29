// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int k, n;
        n = src.nextInt();
        k = src.nextInt();
        System.out.println(countt(n, k));
    }

    static int counter(int n, int k) {
        int count = 0;
        if (k == 1)
            return n;
        else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j % i == 0)
                        count++;
                }
            }
        }
        return count;
    }
 
    static int countt(int n, int k) {
        if (k == 1)
            return n;
        if (k == 2) {
            return counter(n, k);
        }
        int mid = k / 2;
        int x = countt(n, k - mid);
        int y = counter(n, mid);
        System.out.println(x+" "+y);
        return x + y - 1;
    }

}