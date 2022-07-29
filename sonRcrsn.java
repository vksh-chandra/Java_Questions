import java.util.*;
public class sonRcrsn{
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        System.out.println("Enter number for its sum of natural number: ");
        int n = src.nextInt();
        /* if function is not static

        sonRcrsn add = new sonRcrsn();
        int res = add.sum(n);
        
        */
        int res = sum(n);
        System.out.println("Sum of natural number is: "+res);
        src.close();
    }

    public static int sum(int n)
    {
        if(n ==0)
            return n;
        else
            return n + sum(n-1);
    }
}