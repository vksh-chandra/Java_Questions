package Tree;
import java.util.*;

public class PostorderIterative2 {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    static void postorderIte(Node root){
        Stack<Node> s = new Stack<>();
        while(true){
            while(root!=null){
                s.push(root);
                s.push(root);
                root = root.left;
            }
            
            if(s.empty()){
                return;
            }
            root=s.pop();
            if(!s.empty() && s.peek()==root){
                root= root.right;
            }else{
                System.out.print(root.data+" ");
                root=null;
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        
        postorderIte(root);
    }
}
