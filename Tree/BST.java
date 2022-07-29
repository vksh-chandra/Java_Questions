package Tree;
import java.util.*;

public class BST {
    class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    BST(){
        root = null;
    }
    void insert(int key){
        root = insertRes(root, key);
    }
    Node insertRes(Node root, int key){
        if(root ==null){
            root = new Node(key);
            return root;
        }
        if(key<root.data){
            root.left= insertRes(root.left, key);
        }else if(key>root.data){
            root.right = insertRes(root.right, key);
        }
        return root;
    }

    void inorder(){
        inorderRes(root);
    }
    void inorderRes(Node root){
        if(root!=null){
            inorderRes(root.left);
            System.out.print(root.data+" ");
            inorderRes(root.right);
        }
    }

    void preorder(){
        preorderRes(root);
    }
    void preorderRes(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorderRes(root.left);
            preorderRes(root.right);
        }
    }

    void postorder(){
        postorderRes(root);
    }

    void postorderRes(Node root){
        if(root!=null){
            postorderRes(root.left);
            postorderRes(root.right);
            System.out.print(root.data+" ");
        }
    }

    void search(int key){
        int res = serachRes(root, key);
        if(res==-1){
            System.out.println("Not Found");
        }else{
            System.out.println(res);
        }
    }

    int serachRes(Node root, int key){
        if(root==null){
            return -1;
        }
        if(key==root.data){
            return root.data;
        }
        if(key<root.data){
            return serachRes(root.left, key);
        }
        return serachRes(root.right, key);
    }

    void delete(int key){
        root= deleteRes(root, key);
    }

    Node deleteRes(Node root, int key){
        if(root==null){
            return root;
        }
        if(key<root.data){
            root.left = deleteRes(root.left, key);
        }else if(key>root.data){
            root.right = deleteRes(root.right, key);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            root.data = minVal(root.right);
            root.right = deleteRes(root.right, root.data);
        }
        return root;
    }
    int minVal(Node root){
        int min = root.data;
        while(root.left!=null){
            min = root.data;
            root = root.left;
        }
        return min;
    }

    //CHECK BALANCE
    void isBalanced(){
        boolean val = chkBalance(root);
        
        if(val==true){
            System.out.println("\nTree is balance");
        }else{
            System.out.println("\nTree is unbalance");
        }
    }
    
    boolean chkBalance(Node root){
        if(root==null){
            return true;
        }
        int l, r;
        l = chkHeight(root.left);
        r = chkHeight(root.right);

        if(Math.abs(l-r)<=1 && chkBalance(root.left) && chkBalance(root.right)){
            return true;
        }
        return false;
    }

    int chkHeight(Node root){
        if(root==null){
            return 0;
        }
        int res = 1+ Math.max(chkHeight(root.left), chkHeight(root.right));
        return res;
        
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(20);
        tree.insert(15);
        tree.insert(45);
        tree.insert(60);
        tree.insert(10);
        tree.insert(9);
        tree.insert(18);
        tree.insert(7);

        System.out.println("Inoreder is: ");
        tree.inorder();

        System.out.println("\nproreder is: ");
        tree.preorder();

        System.out.println("\nPostoder is: ");
        tree.postorder();

        // tree.delete(10);
        // System.out.println("\nInoreder is: ");
        // tree.inorder();

        tree.isBalanced();

    }
}
