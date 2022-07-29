package Tree;
import java.util.HashMap;

//CONSTRUCT BINARY TREE FROM INOREDR AND PREORDER

public class ConstructBTree1 {
    static class Node{
        char data;
        Node left, right;
        Node(char data){
            this.data=data;
            left = right = null;
        }
    }
    static int preIndx=0;
    static Node buildTreeMain(char[] in, char[] pre, int start, int end, HashMap<Character, Integer> map){
        if(start > end){
            return null;
        }
        char ch = pre[preIndx++];
        Node tNode = new Node(ch);
        if(start==end){
            return tNode;
        }

        int inIdx = map.get(ch);
        tNode.left  =  buildTreeMain(in, pre, start, inIdx-1, map);
        tNode.right =  buildTreeMain(in, pre, inIdx+1, end, map);

        return tNode;
    }

    static Node buildTree(char[] in, char[] pre, int len){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<len;i++){
            map.put(in[i], i);
        }

        return buildTreeMain(in, pre, 0, len-1, map);
    }

    static void printInorder(Node root){
        if(root!=null){
            printInorder(root.left);
            System.out.print(root.data+" ");
            printInorder(root.right);
        }
    }
    public static void main(String[] args) {
        char[] in = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char[] pre = { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = buildTree(in, pre, len);

        System.out.println("Inorder of tree is: ");
        printInorder(root);
    }
}
