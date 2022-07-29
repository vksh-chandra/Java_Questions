import java.util.*;

class Stack1<T>{
    Queue<T> q1, q2;

    public Stack1(){
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    //USING ADD WITH TWO QUEUE

    // void add(T n){
    //     while(!q1.isEmpty()){
    //         q2.add(q1.peek());
    //         q1.poll();
    //     }
    //     q1.add(n);

    //     while(!q2.isEmpty()){
    //         q1.add(q2.peek());
    //         q2.poll();
    //     }
    // }

    // public T poll(){
    //     if(q1.isEmpty()){
    //         System.out.println("Underflow");
    //         System.exit(0);;
    //     }
    //     T front = q1.peek();
    //     q1.poll();
    //     return front;
    // }

    //USING POLL WITH TWO QUEUE
    
    void add(T n){
        q1.add(n);
    }

    public T poll(){

        if (q1.isEmpty())
        {
            System.out.println("Stack Underflow!!");
            System.exit(0);
        }

        T front = null;
        while(!q1.isEmpty()){
            if(q1.size()==1){
                front = q1.peek();
            }
            else{
                q2.add(q1.peek());
            }
            q1.poll();
        }

        while(!q2.isEmpty()){
            q1.add(q2.peek());
            q2.poll();
        }

        return front;
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        Stack1<Integer> s = new Stack1<>();
        s.add(10);
        s.add(5);
        s.add(7);

        System.out.println(s.poll());
        System.out.println(s.poll());
        System.out.println(s.poll());
    }
}
