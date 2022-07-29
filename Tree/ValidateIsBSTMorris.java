package Tree;

import java.util.Scanner;

public class ValidateIsBSTMorris {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr){
        while(leftNode.right != null && leftNode.right != curr){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
    
    public static boolean isValidBST(TreeNode root) {
        TreeNode prev = null, curr = root;
        
        while(curr!=null){
            TreeNode leftNode = curr.left;
            
            if(leftNode==null){
                //inorder region
                
                if(prev !=null && root.val < prev.val){
                    return false;
                } 
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode rmd = getRightMostNode(leftNode, curr);
                
                if(rmd.right==null){ //create thread
                    rmd.right = curr;
                    curr = curr.left;
                }else{ //delete thread
                    if(root.val < prev.val){
                        return false;
                    }
                    
                    rmd.right = null;                    
                    prev = curr;
                    curr = curr.right;
                } 
            }
        }

        return true;
        
    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
