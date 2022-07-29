package Tree;

import java.util.Scanner;

public class ValidateIsBST2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    static TreeNode prev = null;

    public static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        
        boolean lc = isValidBST(root.left);
        if(lc==false){
            return false;
        }
        
        if(prev !=null && root.val <= prev.val){
            return false;
        }
        
        prev = root;
        boolean rc = isValidBST(root.right);
        if(rc==false){
            return false;
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