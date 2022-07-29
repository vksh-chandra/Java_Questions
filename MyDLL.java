public class MyDLL {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    public void push(int data){
        Node ptr = new Node(data);
        ptr.data = data;
        ptr.next = head;
        ptr.prev = null;
        if(head!=null){
            head.prev = ptr;
        }
        
        head = ptr;
    }

    public void printdl(Node head){
        Node temp = head;
        if(temp==null){
            System.out.println("Empty");
        }
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;

        }
    }

    public void reversedll(){
        Node temp = null;
        Node curr = head;
        while(curr!=null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if(temp!=null){
            head = temp.prev;
        }
    }

    public static void main(String[] args) {
        MyDLL dl = new MyDLL();
        dl.push(13);
        dl.push(34);
        dl.push(23);
        dl.push(90);
        dl.push(45);

        dl.printdl(head);

        dl.reversedll();
        System.out.println("Reverse DLl: ");
        dl.printdl(head);

    }
}
