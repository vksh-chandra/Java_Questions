public class MyLinkedList{
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }

    }

    public void push(int data){
        Node new_Node = new Node(data);
        new_Node.next = head;
        head = new_Node;
    }

    public void insertAt(Node prev_node, int data){
        if(prev_node==null){
            System.out.println("previous node can not be empty");
            return;
        }
        Node new_Node = new Node(data);
        new_Node.next = prev_node.next;
        prev_node.next = new_Node;
    }

    public void append(int data){
        Node new_node = new Node(data);

        if(head==null){
            head = new_node;
            return;
        }
        new_node.next = null;

        Node temp = head;
        while(temp.next !=null){
            temp = temp.next;
        }
        temp.next = new_node;
        return;
    }

    public void peek1(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        System.out.println("Peek is: " + head.data);
    }

    public void deleteNode(int data){
        Node temp = head, prev= null;
        if(temp!=null && temp.data==data){
            head = temp.next;
            return;
        }

        while(temp!=null && temp.data!=data){
            prev = temp;
            temp = temp.next;
        }

        if(temp==null)
        {
            return;
        }
        prev.next = temp.next;

    }

    public void deletAtPos(int pos){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head, prev =null;

        if(pos==0){
            head = temp.next;
            return;
        }

        for(int i=0; temp!=null && i<pos-1; i++){
            temp = temp.next;
        }
        if(temp== null){
            return;
        }
        prev = temp.next.next;
        temp.next = prev;
        
    }

    public void printList(){
        Node temp = head;
        while(temp!= null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        
        MyLinkedList llist = new MyLinkedList();

        llist.head = new Node(10);

        Node second = new Node(2);
        llist.head.next = second;

        llist.push(15);
        llist.append(11);
        llist.append(19);
        llist.push(0);

        llist.insertAt(llist.head.next, 111);
        llist.peek1();
        llist.deleteNode(15);
        llist.deletAtPos(2);

        llist.printList();
        

    }
}

//WITH STATIC VARIABLE, CLASS AND METHODS
/*
import org.graalvm.compiler.hotspot.replacements.NewObjectSnippets;

public class MyLinkedList{
    static Node head;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }

    }

    public static void push(int data){
        Node new_Node = new Node(data);
        new_Node.next = head;
        head = new_Node;
    }



    public static void append(int data){
        Node new_node = new Node(data);

        if(head==null){
            head = new_node;
            return;
        }
        new_node.next = null;

        Node temp = head;
        while(temp.next !=null){
            temp = temp.next;
        }
        temp.next = new_node;
        return;
    }

    public static void printList(){
        Node temp = head;
        while(temp!= null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        
        //MyLinkedList llist = new MyLinkedList();

        MyLinkedList.Node node = new MyLinkedList.Node(10);

        head = new Node(5);

        Node second = new Node(2);
        head.next = second;

        push(15);
        append(11);
        append(19);
        push(0);

        printList();
        

    }
}

*/