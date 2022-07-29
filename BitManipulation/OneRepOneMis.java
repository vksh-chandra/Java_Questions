package BitManipulation;
import java.util.*;

public class OneRepOneMis {
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
        int xxory = 0;

        for(int i=0; i<array.length; i++){
            xxory = (xxory ^ array[i]);
        }

        for(int i=1; i<=array.length;i++){
            xxory = (xxory^i);
        }

        int rsbm = (xxory & -xxory);
        int x=0, y=0;

        for(int val : array){
            if((val & rsbm)==0){
                x = (x^val);
            }else{
                y = (y^val);
            }
        }

        for(int i=1; i<=array.length; i++){
            if((i & rsbm)==0){
                x = (x^i);
            }else{
                y = (y^i);
            }
        }

        for(int val: array){
            if(val == x){
                System.out.println("Missing Number -> "+ y);
                System.out.println("Repeating Number -> "+ x);
                break;
            }else if(val == y){
                System.out.println("Missing Number -> "+ x);
                System.out.println("Repeating Number -> "+ y);
                break;
            }
        }

    }
}
