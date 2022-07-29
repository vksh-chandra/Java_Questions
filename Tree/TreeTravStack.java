package Tree;
import java.util.ArrayList;
import java.util.Stack;

class TreeTravStack {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    static class Pair{
        Node first;
        int second;
        public Pair(Node first, int second){
            this.first = first;
            this.second=second;
        }
    }

    static void travesalAll(Node root){
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        
        Stack<Pair> s = new Stack<>();

        s.push(new Pair(root, 1));
        while(!s.empty()){

            Pair p = s.peek();

            if(p.second==1){
                s.peek().second++;
                
                pre.add(p.first.data);
                if(p.first.left!=null){
                    s.push(new Pair(p.first.left, 1));
                }
            }
            else if(p.second==2){
                s.peek().second++;
                in.add(p.first.data);
                if(p.first.right!=null){
                    s.push(new Pair(p.first.right, 1));
                }
            }
            else{
                post.add(p.first.data);
                s.pop();
            }
        }

        System.out.println("preorder: -> "+ pre);
        System.out.println("Inorder: -> "+ in);
        System.out.println("Postorder: -> "+ post);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left= new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        travesalAll(node);
    }
}
