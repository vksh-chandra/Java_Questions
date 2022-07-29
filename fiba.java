import java.util.*;

class fiba{
    public static void main(String args[])  {
        int a=0, b = 1;
        int c=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number to print fabonacci: ");
        int n = input.nextInt();
        System.out.print(a+" "+ b+" ");
        for(int i=0; i<n-2; i++)
        {
            c = a+b;
            a=b; 
            b = c;
        }
        System.out.print(c+" ");

        input.close();
        
    }
}