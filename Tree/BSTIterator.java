package Tree;
import java.util.Scanner;
import java.util.LinkedList;

//USING MORRIS ORDER- o(1) SPACE

public class BSTIterator {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static class BSTIterator1 {
    TreeNode curr;
    public BSTIterator1(TreeNode root) {
      this.curr = root;

    }

  public TreeNode getRightMost(TreeNode leftNode){
    while(leftNode.right!=null && leftNode.right!=this.curr){
      leftNode = leftNode.right;
    }
    return leftNode;
  }

    public int next() {
      //TreeNode r = null;
      int res =0;
      while(this.curr!=null){
        TreeNode leftNode = this.curr.left;
        if(leftNode==null){
          res =  this.curr.val;
          this.curr = this.curr.right;
          break;
        }else{
          TreeNode rightMost = getRightMost(leftNode);
          if(rightMost.right==null){
            //create thread
            rightMost.right = this.curr;
            this.curr = this.curr.left;
          }else{
            //break thread
            res =  this.curr.val;
            this.curr = this.curr.right;
            break;
          }
        }

      }
      //curr= c;

      return res;
    }

    public boolean hasNext() {
      return curr!=null;
    }
  }

  // input_section=================================================

  public static void display(TreeNode node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);

  }

  public static TreeNode constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;

    int mid = (si + ei) / 2;
    TreeNode node = new TreeNode(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();

    TreeNode root = constructFromInOrder_(in, 0, in.length - 1);
    BSTIterator1 itr = new BSTIterator1(root);
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
