public class CircularLL {

    Node head;
    static class Node{
        int data;
        Node next;
        
    }
    static Node push(Node head_ref, int data){
        Node ptr = new Node();
        Node temp = head_ref;
        ptr.data = data;
        ptr.next = head_ref;

        if(head_ref!=null){
            while(temp.next!= head_ref)
                temp = temp.next;
            temp.next = ptr;
        }
        else{
            ptr.next = ptr;
        }
        head_ref = ptr;
        return head_ref;

    }

    static void printCll(Node head_ref){
        Node temp = head_ref;
        if(head_ref!=null){
            do{
                System.out.println(temp.data);
                temp = temp.next;
            }while(temp!=head_ref);
        }        
    }

    public static void main(String[] args) {
        
        Node head = null;
        head = push(head, 12);
        head = push(head, 16);
        head = push(head, 169);
        head = push(head, 10);
        head = push(head, 23);

        printCll(head);

    }
}


// WITHOUT STATIC
/* 
import java.util.*;
public class D {
    Node head;
    class Node{
        int data;
        Node next;
        
    }

    Node push(Node head_ref, int data){

        Node ptr = new Node();
        Node temp = head_ref;
        ptr.data = data;
        ptr.next = head_ref;

        if(head_ref!=null){
            while(temp.next!= head_ref)
                temp = temp.next;
            temp.next = ptr;
        }
        else{
            ptr.next = ptr;
        }
        head_ref = ptr;
        return head_ref;

    }

    void printCll(Node head_ref){
        Node temp = head_ref;
        if(head_ref!=null){
            do{
                System.out.println(temp.data);
                temp = temp.next;
            }while(temp!=head_ref);
        }        
    }

    public static void main(String[] args) {
        
        D n = new D();

        Node head = null;
        head = n.push(head, 12);
        head = n.push(head, 16);
        head = n.push(head, 169);
        head = n.push(head, 10);
        head = n.push(head, 23);

        n.printCll(head);

    }
}
*/
