import java.util.*;

public class mxmInArray {
    public static void main(String[] args) {
        int[] a = new int[5];
        Scanner src = new Scanner(System.in);
        System.out.println("Enter elements: ");
        for(int i=0; i<a.length; ++i)
        {
            a[i] = src.nextInt();
        }
        src.close();

        int mxm = a[0];
        for(int i : a)
        {
            if(mxm < i)
            {
                mxm = i;
            }
        }
        System.out.println("largest in array is: " +mxm);
    }
    
}
