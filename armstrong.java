import java.util.Scanner;

public class armstrong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number to check for sramstrong: ");
        int n = input.nextInt();
        int digit=0, temp;
        int rem, sum =0;
        temp = n;
        while(temp!=0)
        {
            temp= temp/10;
            digit++;
        }
        temp = n;
        while(temp!=0)
        {
            rem = temp%10;
            sum += Math.pow(rem, digit);
            temp= temp/10;
        }

        if(sum == n)
            System.out.println("Armstrong no.");
        else{
            System.out.println("Not an armstrong no.");

        }
        
            input.close();

    }
    
}
