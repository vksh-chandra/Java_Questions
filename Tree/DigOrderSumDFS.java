package Tree;
import java.util.*;

public class DigOrderSumDFS {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  
  public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();  
    if(root==null){
      return res;
    }

    getSum(root, 0, res);
    return res;
  }

  public static void getSum(TreeNode root, int idx, ArrayList<Integer> res){

    if(root==null){
      return;
    }

    if(idx==res.size())
      res.add(0);
    
    res.set(idx, res.get(idx)+root.val);

    getSum(root.left, idx+1, res);
    getSum(root.right, idx+0, res);
    
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

    ArrayList<Integer> ans = diagonalOrderSum(root);
    for (Integer j : ans)
      System.out.print(j + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}

