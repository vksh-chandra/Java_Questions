public class DLL {
    
    Node head;
    class Node{
        int data;
        Node prev;
        Node next;
    }

    public Node push(Node head_ref, int data){
        Node ptr = new Node();

        ptr.data = data;
        ptr.next = head_ref;
        ptr.prev = null;
        if(head_ref!=null){
            head_ref.prev = ptr;
        }
        
        head_ref = ptr;

        return head_ref;
    }

    public void appneddll(Node head, int data){
        Node ptr = new Node();
        ptr.data = data;
        

        Node temp = head;
        if(head==null){
            ptr.next = null;
            ptr.prev = null;
            head = ptr;
        }

        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = ptr;
        ptr.prev = temp;
        ptr.prev = null;
    }

    public void deletedllNode(Node head_ref, int data){
        Node temp = head_ref;
        Node pre = null;
        if(head_ref==null){
            System.out.println("Empty");
            return;
        }
        if(head_ref.data == data){
            head_ref = head_ref.next;
        }
        while(temp.data!=data){
            pre = temp;
            temp = temp.next;
        }
        if(temp.next!=null){
            temp.next.prev = pre;
            pre.next = temp.next;
        }
        else{
            temp.prev = null;
            pre.next = null;
        }
        return;
    }

    public void reverseDll(Node head){
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
        //System.out.println(temp.prev);

    }

    public void printdll(Node head_ref){
        Node temp = head_ref;
        if(head_ref==null){
            System.out.println("Empty");
            return;
        }
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DLL dll = new DLL();

        Node head = null;
        head = dll.push(head, 12);
        head = dll.push(head, 22);
        head = dll.push(head, 10);
        head = dll.push(head, 100);
        head = dll.push(head, 123);
        head = dll.push(head, 126);
        dll.appneddll(head, 55);
        dll.deletedllNode(head, 22);
        dll.printdll(head);

        dll.reverseDll(head);
        System.out.println("reverse: ");
        dll.printdll(head);
    }
}
