package Tree;
import java.util.Stack;

public class InorderIterative {
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data=data;
            left=null; right=null;
        }
    }
    /*
        LEFT ROOT RIGHT

        First push root
        then push left nodes one by one (as we have to print last left node first)
        when gets null
        print it 
        then print root and
        then print it ans check for right node
    */

    static void inorderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while(curr!=null || stack.size()>0){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                curr = stack.pop();
                System.out.print(curr.data+" ");
                curr = curr.right;
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
 
        inorderIterative(root);
    }
}
