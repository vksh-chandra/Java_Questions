package Tree;
import java.util.HashMap;

//CONSTRUCT BINARY TREE FROM INOREDR AND POSTORDER

public class ConstructBTree2 {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    static int pIdx;
    static Node consturctBtreeMain(int[] in, int[] post, int start, int end, HashMap<Integer, Integer> map){
        if(start>end){
            return null;
        }
        int n = post[pIdx];
        Node tNode = new Node(n);
        pIdx--;
        if(start==end){
            return tNode;
        }
        int inIdx = map.get(n);
        tNode.right = consturctBtreeMain(in, post, inIdx+1, end, map);
        tNode.left = consturctBtreeMain(in, post, start, inIdx-1, map);
        
        return tNode;

    }

    static Node consturctBtree(int[] in, int[] post, int len){
        HashMap<Integer, Integer> map = new HashMap<>();
        pIdx = len-1;
        
        for(int i=0;i<len;i++){
            map.put(in[i], i);
        }
        return consturctBtreeMain(in, post, 0, len-1, map);
    }
    static void printInorder(Node root){
        if(root!=null){
            printInorder(root.left);
            System.out.print(root.data+" ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        int in[] =   { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
        int len = in.length;
        Node root = consturctBtree(in, post, len);

        System.out.println("Inorder: ");
        printInorder(root);

    }
}
