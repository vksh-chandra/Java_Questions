import java.util.*;
public class binaryToDec {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        System.out.println("Enter binary number: ");
        long bin = src.nextLong();

        int dec = (int)binToDec(bin);
        System.out.println("The decimal of binary "+ bin+ " is "+dec);
        src.close();
    }

    public static int binToDec(long bin)
    {
        int dec = 0, i =0;
        long rem;
        while(bin!=0)
        {
            rem = bin %10;
            bin /=10;
            dec = dec + (int)rem* (int)Math.pow(2,i);
            ++i;
        }
        return dec;
    }
}
