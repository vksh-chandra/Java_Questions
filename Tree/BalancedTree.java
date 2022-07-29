package Tree;
class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class Height{
    int height =0;
}

public class BalancedTree{

    Node root;
    boolean isBalanced(Node root, Height h){
        if(root == null){
            h.height=0;
            return true;
        }

        Height lhight = new Height(), rheight = new Height();
        boolean l = isBalanced(root.left, lhight);
        boolean r = isBalanced(root.right, rheight);
        int lh = lhight.height, rh = rheight.height;

        h.height = (lh > rh ? lh:rh)+1;

        if(Math.abs(lh-rh)>=2){
            return false;
        }

        return l && r;
    }

    public static void main(String[] args) {
        Height height = new Height();

        BalancedTree tree = new BalancedTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
 
        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}