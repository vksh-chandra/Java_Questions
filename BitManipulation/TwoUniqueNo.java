package BitManipulation;
import java.util.*;
public class TwoUniqueNo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
        arr[i] = scn.nextInt();
        }
        solution(arr);
        scn.close();
    }
    public static void solution(int[] array){
        int xxory =0;

        //a^b^a^c^d^d^e^e = b^c
        for(int i=0;i<array.length;i++){
            xxory = xxory^array[i];
        }

        //right most set bit of b^c 
        //then check which bit is off or on and get two different number
        int rsbm = (xxory & -xxory);

        int x=0, y=0;
        for(int val: array){
            //the right most bit is off
            if((val & rsbm)==0){
                x = (x^val);
            }else{
                y = (y^val);
            }
        }

        if(x<y){
            System.out.println(x);
            System.out.println(y);
        }else{
            System.out.println(y);
            System.out.println(x);
        }

    }
}
