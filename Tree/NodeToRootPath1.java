package Tree;
import java.util.*;

//RETURN TYPE METHOD

public class NodeToRootPath1 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
 
  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
    if(node==null){
      return null;
    }

    if(node.val==data){
      //returning address of this list
      ArrayList<TreeNode> blist = new ArrayList<TreeNode>();
      blist.add(node);
      return blist;
    }

    //caatching address -> if not null then add data to recived address
    ArrayList<TreeNode> lc = nodeToRootPath(node.left, data);
    if(lc!=null){
      lc.add(node);
      return lc;
    }
    ArrayList<TreeNode> rc = nodeToRootPath(node.right, data);
    if(rc!=null){
      rc.add(node);
      return rc;
    }

    return new ArrayList<TreeNode>();


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

    int data = scn.nextInt();
    ArrayList<TreeNode> ans = nodeToRootPath(root, data);
    if (ans.size() == 0)  System.out.println();
    for (TreeNode node : ans)
      System.out.print(node.val + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
