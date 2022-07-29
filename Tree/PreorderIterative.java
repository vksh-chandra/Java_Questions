package Tree;
import java.util.Stack;

public class PreorderIterative {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    /*
        ROOT LEFT RIGHT

        First push
        then visit right nodes (as we have to print right node in last)
        then visit left node (as we have to print it first.)
    */

    static void preorderIterative(Node root){
        if(root==null){
            return;
        }

        Stack<Node> s = new Stack<>();
        s.push(root);
        Node cur = root;

        while(!s.empty()){
            if(cur != null){
                System.out.print(cur.data+" ");
                if(cur.right != null){
                    s.push(cur.right);
                }
                cur = cur.left;  //left wala stack m ja hi nai raha bas print ho raha so space will be equal to height.
            }else{
                cur = s.pop();
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
 
        preorderIterative(root);
    }
}
