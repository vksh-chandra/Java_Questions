package Tree;
import java.util.*;

public class LeftViewBTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return array;
        }
        queue.addLast(root);
        int level =0;
        while(queue.size()>0){
            int s = queue.size();
            level =0;
            while(s-- >0){
                TreeNode rem = queue.removeFirst();
                if(level==0){
                    array.add(rem.val);
                }
                level++;
                
                if(rem.left!=null){
                    queue.addLast(rem.left);
                }
                if(rem.right!=null){
                    queue.addLast(rem.right);
                }
            }
        }

        return array;

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

        ArrayList<Integer> ans = leftView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}
