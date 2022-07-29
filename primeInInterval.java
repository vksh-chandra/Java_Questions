import java.util.*;
public class primeInInterval {
    
    public static void main(String args[]) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter range to find prime: ");
        int n1 = src.nextInt();
        int n2 = src.nextInt();
        System.out.println("Prime numbers are: ");
        while(n1<n2)
        {
          if(isPrime(n1))
              System.out.println(n1);
          ++n1;
        }
        src.close();

      }

    public static boolean isPrime(int n)
    {
        boolean flag = true;
        for(int i=2; i<=n/2;i++)   // n/2 as number is not divisible by more than its half.
        {
            if(n%i ==0)
            {
                flag = false;
                break;
            }  
        }
        return flag;
    }
    
    
    
}