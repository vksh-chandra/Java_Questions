package Tree;
import java.util.Scanner;

//USING MORRISH ORDER TRAVERSAL

public class ConvertBSTtoDLL3 {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }

  public static Node getRightMost(Node leftNode, Node curr){
    while(leftNode.right !=null && leftNode.right != curr){
      leftNode = leftNode.right;
    }
    return leftNode;
  }

  public static Node bToDLL(Node root) {
    
    Node curr = root;
    Node dummy = new Node(-1);
    Node prev = dummy;

    while(curr != null){
      Node leftNode = curr.left;
      if(leftNode==null){
        //inorder
        prev.right = curr;
        curr.left = prev;
        prev = curr;
        curr = curr.right;


      }else{
        Node rightNode = getRightMost(leftNode, curr);
        if(rightNode.right==null){
          //create thread
          rightNode.right = curr;
          curr = curr.left;
        }else{
          //break thread
          //inorder
          prev.right = curr;
          curr.left = prev;
          prev = curr;
          curr = curr.right;
        }
      }
    }

    Node head = dummy.right;
    dummy.right = head.left = null;
    head.left = prev;
    prev.right = head;
    return head;

  }

  // input_section=================================================

  public static void display(Node node) {
    Node head = node;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.right;
      if (node == head)
        break;
    }

  }

  public static Node constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;

    int mid = (si + ei) / 2;
    Node node = new Node(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
  }

  public static Node constructFromInOrder(int[] inOrder) {
    int n = inOrder.length;
    return constructFromInOrder_(inOrder, 0, n - 1);
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();

    Node root = constructFromInOrder(in);
    root = bToDLL(root);
    display(root);
  }

  public static void main(String[] args) {
    solve();
  }
}
