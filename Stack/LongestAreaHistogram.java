package Stack;

import java.io.*;
import java.util.*;

public class LongestAreaHistogram{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code

   int[] rb = new int[arr.length]; //boundary of right most shortest bar
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        rb[arr.length-1] = arr.length;

       for(int i=arr.length-2; i>=0; i--){
          while(st.size()>0 && arr[i]<=arr[st.peek()]){
             st.pop();
          }
          if(st.size()==0){
             rb[i] = arr.length;
          }else{
             rb[i] = st.peek();
          }
          st.push(i);
       }

   
       int[] lb = new int[arr.length];   //boundary of left most shortest bar
       Stack<Integer> stack = new Stack<>();
       stack.push(0);
       lb[0] = -1;
       for(int i=1; i<arr.length; i++){
          while(stack.size()>0 && arr[i]<=arr[stack.peek()]){
             stack.pop();
          }
           
          if(stack.size()==0){
             lb[i] = -1;
          }else{
             lb[i] = stack.peek();
          }
          stack.push(i);
       }
        
       int maxArea=0;
       for(int i=0; i<arr.length; i++){
          int width = rb[i] - lb[i] -1;
          int area = arr[i]*width;
          maxArea = Math.max(maxArea, area);
       }

       //return maxArea;
   System.out.println(maxArea);
 }
}
