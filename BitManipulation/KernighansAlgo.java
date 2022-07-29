package BitManipulation;

import java.util.Scanner;

// count the number of set bits in the given number.

public class KernighansAlgo {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int count=0;
        while(n!=0){
            //using right most shift bit
            int rsb = n & -n;
            n -= rsb;
            //other merhod is
            //n = n&(n-1);
            count++;
        }
        System.out.println(count);

        src.close();
    }
}
