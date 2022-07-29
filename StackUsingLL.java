import java.util.*;

public class StackUsingLL {
    class Node{
        int data;
        Node next;
    }

    Node top;
    public StackUsingLL(){
        this.top = null;
    }

    public void push(int n){
        Node newNode = new Node();
        if(newNode==null){
            //System.out.println("Stack Overlfow");
            return;
        }
        newNode.data = n;
        newNode.next = top;
        top = newNode;
    }

    public boolean isEmpty(){
        return top==null;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Empty stack");
            return -1;
        }
        return top.data;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Empty Stack");
            return;
        }
        top = top.next;
    }
    public void displayStack(){
        if(isEmpty()){
            System.out.println("Empty Stack");
            return;
        }
        Node temp = top;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(6);
        System.out.println("Stack created is: ");
        stack.displayStack();

        stack.pop();
        stack.pop();
        System.out.println("Stack after deletion is: ");
        stack.displayStack();

    }
}
