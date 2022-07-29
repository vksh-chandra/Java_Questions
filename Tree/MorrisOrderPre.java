package Tree;
import java.util.*;

public class MorrisOrderPre {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode getRightMost(TreeNode leftNode, TreeNode cur){

    while(leftNode.right!=null && leftNode.right != cur){
      leftNode = leftNode.right;
    }
    return leftNode;

  }

  public static ArrayList<Integer> morrisPreTraversal(TreeNode Treenode) {
    
    ArrayList<Integer> res = new ArrayList<>();
    TreeNode cur = Treenode;
    while(cur!=null){
      TreeNode leftNode = cur.left;
      if(leftNode==null){
        res.add(cur.val);
        cur = cur.right;
      }else{

        TreeNode rightMost = getRightMost(leftNode, cur);

        if(rightMost.right==null){ //create thread
          rightMost.right = cur;
          res.add(cur.val);
          cur = cur.left;
        }else{ //break thread
          rightMost.right = null;
          cur = cur.right;
        }

      }
    }

    return res;

  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    ArrayList<Integer> ans = morrisPreTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}