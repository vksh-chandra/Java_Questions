package BitManipulation;
import java.util.*;

public class ThreeRepExcOne {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
          arr[i] = scn.nextInt();
        }
        solution(arr);
        scn.close();
      }
    
      public static void solution(int[] arr){
       int tn = Integer.MAX_VALUE, tn1 =0, tn2=0;
       
       for(int i=0; i<arr.length;i++){
           
           int cw0 = tn & arr[i];
           int cw1 = tn1 & arr[i];
           int cw2 = tn2 & arr[i];
           
           tn1 = tn1 | cw0;
           tn = tn & (~cw0);
           
           tn1 = tn1 & (~cw1);
           tn2 = tn2 | cw1;
           
           tn2 = tn2 & (~cw2);
           tn = tn | cw2;
           
       }
       System.out.println(tn1);
       
      }
}
