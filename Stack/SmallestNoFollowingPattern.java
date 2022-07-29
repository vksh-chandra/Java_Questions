package Stack;

import java.io.*;
import java.util.*;

public class SmallestNoFollowingPattern{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code
    Stack<Integer> stack = new Stack<>();
    int num=1;
    
    for(int i=0; i<str.length();i++){
        char ch = str.charAt(i);
        if(ch=='i'){
            //push in stack
            stack.push(num);
            num++;
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
        }else{
            stack.push(num);
            num++;
        }
    }
    stack.push(num);
    while(!stack.isEmpty()){
        System.out.print(stack.pop());
    }

 }
}
