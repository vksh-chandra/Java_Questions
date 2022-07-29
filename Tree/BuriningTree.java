package Tree;
import java.util.*;

public class BuriningTree {
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
      return new ArrayList<TreeNode>();
    }

    if(node.val==data){
      ArrayList<TreeNode> bres = new ArrayList<TreeNode>();
      bres.add(node);
      return bres;
    }

    ArrayList<TreeNode> lc = nodeToRootPath(node.left, data);
    if(lc.size()>0){
      lc.add(node);
      return lc;
    }
    ArrayList<TreeNode> rc = nodeToRootPath(node.right, data);
    if(rc.size()>0){
      rc.add(node);
      return rc;
    }

    return new ArrayList<TreeNode>();
  }


  static int time=0;
  public static int burningTree(TreeNode root, int fireNode) {
    ArrayList<TreeNode> path = nodeToRootPath(root, fireNode);
    int count=0;
    for(int i=0; i<path.size(); i++){
      burningTree(path.get(i), i==0?null:path.get(i-1), count);
      count++;
    }
    return time;
  }

  public static void burningTree(TreeNode root, TreeNode blocker, int count){
    if(root==null || root==blocker){
      return;
    }

    time = Math.max(time, count);
    burningTree(root.left, blocker, count+1);
    burningTree(root.right, blocker, count+1);

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
    int fireNode = scn.nextInt();

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}
