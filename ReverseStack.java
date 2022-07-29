import java.util.*;
public class ReverseStack {
    public static void reversedStack(Stack<Integer> s, int key){
        if(s.empty()){
            s.push(key);
            return;
        }
        int top = s.pop();
        reversedStack(s, key);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);

        reversedStack(s, top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=5;i++){
            stack.push(i);
        }
        System.out.println("Stack is: "+stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: "+stack);
    }
}
