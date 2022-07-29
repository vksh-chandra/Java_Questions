package Tree;
import java.util.*;

public class BottomViewBTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void width(TreeNode root, int hl, int[] arr){
        if(root==null) return;
        arr[0] = Math.min(arr[0], hl);
        arr[1] = Math.max(arr[1], hl);

        width(root.left, hl-1, arr);
        width(root.right, hl+1, arr);
    }

    public static class Pair{
        TreeNode node=null;
        int hl=0;
        Pair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }

    public static ArrayList<Integer> BottomView(TreeNode root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }

        int[] minMax = new int[2];
        width(root, 0, minMax);
        int len = minMax[1]-minMax[0]+1;
        for(int i=0; i<len; i++){
            ans.add(0);
        }

        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root, Math.abs(minMax[0])));

        while(queue.size()>0){
            int s = queue.size();
            while(s-- >0){
                Pair rem = queue.removeFirst();
                TreeNode node = rem.node;
                int hl = rem.hl;
                ans.set(hl, node.val);

                if(node.left!=null){
                    queue.addLast(new Pair(node.left, hl-1));
                }
                if(node.right!=null){
                    queue.addLast(new Pair(node.right, hl+1));
                }

            }
        }
        return ans;

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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
