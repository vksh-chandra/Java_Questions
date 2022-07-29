package Tree;
import java.util.Scanner;

public class MaxSumLeafToLeaf {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static int ltl = -(int)1e9-1;
  public static int maxPathSum_(TreeNode root) {
    if(root==null){
      return -(int)1e9-1;
    }
    if(root.left==null && root.right==null){
      return root.val;
    }

    int ntl_left = maxPathSum_(root.left);
    int ntl_right = maxPathSum_(root.right);

    if(root.left!=null && root.right!=null){
      ltl = Math.max(ltl, ntl_left+root.val + ntl_right);
    }

    return Math.max(ntl_left, ntl_right)+root.val;
  }

  public static int maxPathSum(TreeNode root) {
    int res = maxPathSum_(root);
    return ltl;
  }

  // input_Section=================================================

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
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}