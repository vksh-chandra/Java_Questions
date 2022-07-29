import java.util.*;
class MinStk{
    private Stack<Integer> aux;
    private Stack<Integer> st;


    public MinStk(){
        st = new Stack<>();
        aux = new Stack<>();
    }
    
    public void push(int n){
        st.add(n);
        if(aux.empty()){
            aux.push(n);
        }
        else if(n <= aux.peek()){
            aux.push(n);
        }
    }

    public int pop(){
        if(st.empty()){
            System.out.println("Stack underflow");
            return -1;
        }
        int top = st.pop();
        if(top==aux.peek()){
            aux.pop();
        }

        return top;
    }

    public int min(){
        if(aux.isEmpty()){
            System.out.println("Stack underlfow");
            return -1;
        }
        return aux.peek();
    }
}

public class MinUsingStack {
    public static void main(String[] args) {
        //Scanner src = new Scanner(System.in);

        MinStk s = new MinStk();
        s.push(6);
        System.out.println(s.min());    // prints 6
 
        s.push(7);
        System.out.println(s.min());    // prints 6
 
        s.push(8);
        System.out.println(s.min());    // prints 6
 
        s.push(5);
        System.out.println(s.min());    // prints 5
 
        s.push(3);
        System.out.println(s.min());    // prints 3
 
        s.pop();
        System.out.println(s.min());    // prints 5
 
        s.push(10);
        System.out.println(s.min());    // prints 5
 
        s.pop();
        System.out.println(s.min());    // prints 5
 
        s.pop();
        System.out.println(s.min()); 

        //THIS CAN BE DONE LIKE THIS TOO....

        // Stack<Integer> stack1 = new Stack<>();
        // Stack<Integer> stack2 = new Stack<>();
        // System.out.println("How many number you want to enter");
        // int t = src.nextInt();
        // while(t-->0){
        //     int n = src.nextInt();
        //     stack1.add(n);
        //     if(stack2.isEmpty()){
        //         stack2.add(n);
        //     } else if(n < stack2.peek()){
        //         stack2.add(n);
        //     }
        // }
        // System.out.println("Min = "+stack2.peek());
    }
}

