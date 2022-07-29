import java.util.*;
public class decToBin {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        System.out.println("Enter Decimal number: ");
        int n = src.nextInt();
        long bin = decTobin(n);
        System.out.println("The binary form : "+bin);
        src.close();
    }

    public static long decTobin(int n)
    {
        int i=1, rem;
        long bin =0;
        while(n!=0)
        {
            rem = n%2;
            bin =bin + rem*i;
            i *= 10;
            n /=2;
        }
        return bin;
    }
}
