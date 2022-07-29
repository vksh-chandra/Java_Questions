package Tree;

import java.util.*;

public class DiagOrderBTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while(queue.size()>0){
            int s = queue.size();
            ArrayList<Integer> sub = new ArrayList<>();
            while(s-- >0){

                TreeNode node = queue.removeFirst();
                
                sub.add(node.val);

                //add left node to create base for next diagonal
                if(node.left!=null){
                    queue.addLast(node.left);
                }

                //make node at node.right
                //traverse each right node from each root and add to arraylis
                //and also add each right child's left child to queue for next diagonal
                TreeNode r = node.right;
                while(r!=null){
                    if(r.left!=null){
                        queue.addLast(r.left);
                    }
                    sub.add(r.val);
                    r = r.right;
                }

            }
            res.add(sub);
        }
        return res;

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
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

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}