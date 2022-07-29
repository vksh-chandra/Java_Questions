package Tree;

public class AVLTree{
  class Node{
    int data, height;
    Node left, right;

    Node(int data){
      this.data = data;
      height=1;
    }
  }

  int height(Node node){
    if(node==null){
      return 0;
    }
    return node.height;
  }

  Node root;
  AVLTree(){
    root=null;
  }

  int max(int a, int b){
    return a>b? a: b;
  }

  Node leftRotate(Node x){
    Node y = x.right;
    Node temp = y.left;
    y.left = x;
    x.right = temp;
    x.height = Math.max(height(x.left), height(x.right))+1;
    y.height = Math.max(height(y.left), height(y.right))+1;
    return y;
  }

  Node rightRotate(Node y){
    Node x = y.left;
    Node temp = x.right;
    x.right = y;
    y.left = temp;
    x.height = Math.max(height(x.left), height(x.right))+1;
    y.height = Math.max(height(y.left), height(y.right))+1;
    return x;
  }

  int balanceFactor(Node node){
    if(node==null){
      return 0;
    }
    return height(node.left)-height(node.right);
  }

  void insertNode(int key){
    root = insert(root, key);
  }

  Node insert(Node node, int key){
    if(node==null){
      return (new Node(key));
    }
    if(key<node.data){
      node.left = insert(node.left, key);
    }else if(key>node.data){
      node.right = insert(node.right, key);
    }else{
      return node;
    }

    node.height = 1 + Math.max(height(node.left), height(node.right));
    int balance = balanceFactor(node);

    if(balance>1){
      if(key < node.left.data){
        return rightRotate(node);
      }else if(key > node.left.data) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
      }
    }

    if(balance < -1){
      if(key>node.right.data){
        return leftRotate(node);
      }else if(key<node.right.data){
        node.right = rightRotate(node.right);
        return leftRotate(node);
      }
    }
    return node;
  }

  Node minValNode(Node node){
    Node min = node;
    while(min.left!=null){
      min = min.left;
    }
    return min;
  }

  void delete(int key){
    root = deleteNode(root, key);
  }

  Node deleteNode(Node node, int key){
    if(node==null){
      return node;
    }
    if(key<node.data){
      node.left = deleteNode(node.left, key);
    }else if(key>node.data){
      node.right = deleteNode(node.right, key);
    }else{
      if(node.left==null || node.right==null){
        Node temp=null;
        if(node.left==temp){
          temp = node.right;
        }else{
          temp = node.left;
        }
        if(temp==null){
          temp=node;
          node=null;
        }else{
          node=temp;
        }
      }else{
        Node temp = minValNode(node.right);
        node.data = temp.data;
        node.right = deleteNode(node.right, temp.data);
      }
      if(node==null){
        return node;
      }
      
      node.height = Math.max(height(node.left), height(node.right))+1;
      int balance = balanceFactor(node);

      if(balance>1){
        if(balanceFactor(node.left)>=0){
          return rightRotate(node);
        }else{
          node.left = leftRotate(node.left);
          return rightRotate(node);
        }
      }
      
      if(balance<-1){
        if(balanceFactor(node.right) <= 0){
          return leftRotate(node);
        }else{
          node.right = rightRotate(node.right);
          return leftRotate(node);
        }
      }

    }
    return node;
  }

  void preOrder(){
    preOrderPrint(root);
  }
  void preOrderPrint(Node root){
    if(root!=null){
      System.out.print(root.data+" ");
      preOrderPrint(root.left);
      preOrderPrint(root.right);
    }
  }

  public static void main(String[] args) {
    AVLTree tree = new AVLTree();
    tree.insertNode(33);
    tree.insertNode(13);
    tree.insertNode(53);
    tree.insertNode(9);
    tree.insertNode(21);
    tree.insertNode(61);
    tree.insertNode(8);
    tree.insertNode(11);

    System.out.println("Tree is: ");
    tree.preOrder();

    tree.delete(13);
    System.out.println("\nTree After Deletion: ");
    tree.preOrder();

    tree.insertNode(7);
    System.out.println("\nTree after inserting 7: ");
    tree.preOrder();

  }

}