package Stack;
import java.io.*;
import java.util.*;

public class NextGEonRight{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   int len = arr.length;
   int[] res = new int[len];

   Stack<Integer> stack = new Stack<>();
   for(int i=len-1; i>=0; i--){
      
        while(!stack.isEmpty() && stack.peek()<arr[i]){
          stack.pop();
        }

        if(!stack.isEmpty()){
          res[i] = stack.peek();
        }else{
          res[i] = -1;
        }
        stack.push(arr[i]);

    }

    return res;
 }

}