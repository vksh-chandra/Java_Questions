import java.util.*;
public class gcdRcrsn{
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

       // System.out.println("Enter two numbers to find their GCD: ");
        int n1 = src.nextInt();
        int n2 = src.nextInt();

        int res = gcd(n1, n2);
        //System.out.println("The GCD of "+n1+" and "+ n2+" is "+res);
        System.out.println(res);
        src.close();

    }

    public static int gcd(int n1, int n2)
    {
        int n = Math.min(n1,n2);
        int m = Math.max(n1,n2);
        if(n!=0)
            return gcd(n, m%n);
        else   
            return m;
        
    }
}