package Tree;
import java.util.*;

public class BurningTree2 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void burningTreeBlok(TreeNode root, TreeNode blocker, int time, ArrayList<ArrayList<Integer>> res){
    if(root==null || root==blocker){
      return;
    }

    if(time==res.size()) res.add(new ArrayList<>());
    res.get(time).add(root.val);

    burningTreeBlok(root.left, blocker, time+1, res);
    burningTreeBlok(root.right, blocker, time+1, res);

  }

  public static int burningTreeFind(TreeNode root, int data, ArrayList<ArrayList<Integer>> res){
    if(root==null){
      return -1;
    }

    if(root.val==data){
      burningTreeBlok(root,null, 0, res);
      return 1;
    }

    int lct = burningTreeFind(root.left, data, res);
    if(lct!= -1){
      burningTreeBlok(root, root.left, lct, res);
      return lct+1;
    }

    int rct = burningTreeFind(root.right, data, res);
    if(rct!=-1){
      burningTreeBlok(root, root.right, rct, res);
      return rct+1;
    }

    return -1;

  }

  public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      burningTreeFind(root, data, res);
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
    int fireNode = scn.nextInt();

    ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
