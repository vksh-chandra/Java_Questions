package Tree;
import java.util.*;

public class IsBST {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    
    Node root;
    public boolean isBST(){
        return isBSTMain(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTMain(Node root, int min, int max){
        if(root==null)
            return false;
        
        if(root.data<min || root.data>max){
            return false;
        }
        return isBSTMain(root.left, min, root.data-1) && isBSTMain(root.right, root.data+1, max);
    }
    public static void main(String[] args) {
        IsBST tree = new IsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
