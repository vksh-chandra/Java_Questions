package Tree;
import java.util.*;

public class PostorderIterative {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    static ArrayList<Integer> postorderIterative(Node root){
        Node cur = root;
        Node prev = null;
        Stack<Node> s = new Stack<>();
        ArrayList<Integer> array = new ArrayList<>();
        s.push(cur);

        while(!s.empty()){
            cur = s.peek();

            if(prev==null || prev.left==cur || prev.right==cur){
                if(cur.left!=null)
                    s.push(cur.left);
                else if(cur.right!=null)
                    s.push(cur.right);
                else{
                    s.pop();
                    array.add(cur.data);
                }
            }

            else if(cur.left==prev){
                if(cur.right!=null){
                    s.push(cur.right);
                }else{
                    s.pop();
                    array.add(cur.data);
                }
            }
            else if(cur.right==prev) {
                s.pop();
                array.add(cur.data);
            }
            prev = cur;
        }
        return array;
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

        ArrayList<Integer> array =  postorderIterative(root);
        System.out.println(array);
    }
}
