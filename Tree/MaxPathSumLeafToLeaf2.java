package Tree;

import java.util.Scanner;

public class MaxPathSumLeafToLeaf2 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static class Pair{
    int ntl = -(int)1e9-1;
    int ltl = -(int)1e9-1;
  }

  public static Pair maxPathSum_01(TreeNode root){

    Pair ans = new Pair();
    if(root==null){
      return ans;
    }

    if(root.left==null && root.right==null){
      ans.ntl = root.val;
      //ans.ltl = -(int)1e9-1;
      return ans;
    }

    Pair lp = maxPathSum_01(root.left);
    Pair rp = maxPathSum_01(root.right);

    //max of left and right ka leaf to leaf yaha store kie haii
    ans.ltl = Math.max(lp.ltl, rp.ltl);
    if(root.left!=null && root.right!=null){
      ans.ltl = Math.max(ans.ltl, lp.ntl+root.val+rp.ntl);
    }

    ans.ntl = Math.max(lp.ntl, rp.ntl)+root.val;
    return ans;

  }

  public static int maxPathSum(TreeNode root) {
    if(root==null){
      return 0;
    }

    Pair ans = maxPathSum_01(root);
    return ans.ltl;

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
