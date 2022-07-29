import java.util.*;
public class RecurSortStack {
    static void sortedStack(Stack<Integer> s, int key){
        if(s.empty()|| key>s.peek()){
            s.push(key);
            return;
        }
        int top = s.pop();
        sortedStack(s, key);
        s.push(top);
    }

    static void sortStack(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        int top = s.pop();
        sortStack(s);

        sortedStack(s, top);
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter element to sort: ");
        for(int i=1;i<=5;i++){
            stack.push(src.nextInt());
        }
        System.out.println("Before soring: "+stack);
        sortStack(stack);
        System.out.println("After sorting: "+stack);

        src.close();
    }
}
