//Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree
import java.io.*;


/* Class containing left and right child of current
node and key value*/
public class node{
    int data;
    node left;
    node right;
    node(int data){
        this.data = data;
    }

    public static void main(String args[] ) throws Exception {
        String inputData = "";
        String thisLine = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((thisLine = br.readLine()) != null) {
            inputData += thisLine + "\n";
        }
        System.out.println(codeHere(inputData));
	}

    public static node construct(){
        node root = new node(20);
		root.left = new node(8);
		root.right = new node(22);
		root.left.left = new node(4);
		root.left.right = new node(12);
		root.right.left = new node(10);
		root.right.right = new node(14);
        return root;
    }

    public static String codeHere(String inputData) {
        // Use this function to write your solution;
        String input[] = inputData.split("\n");
        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);
        node root = construct();
        node res = lca(root, n1, n2);
        //node res = lca(root, n1, n2);
        String s = res.data+"";
        return s;
    }

    public static node lca(node root, int n1, int n2){
        if(root==null){
            return root;
        }
        if(root.data<n1 && root.data<n2){
            return lca(root.right, n1, n2);
        }else if(root.data>n1 && root.data>n2){
            return lca(root.left, n1,n2);
        }else{
            return root;
        }
    }

}
