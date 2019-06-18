package customtree;

public class CustomBinaryTree<E> {

  /**
   * The binary tree is built using this nested node class. Each node stores one data element, and
   * has left and right sub-tree pointer which may be null,  just used for storage; it does not have
   * any methods.
   */
  protected class Node<E> {

    E value;
    int balanceFactor;
    Node leftChild = null;
    Node rightChild = null;

    Node(E value) {
      this.value = value;
      balanceFactor = 0;
    }
  }

  protected Node<E> root;

  /**
   * Inserts the given data into the binary tree. Uses a recursive helper.
   */
  public void add(E value) {
    root = add(root, value);
  }

  /**
   * Recursive insert given a node pointer, recur down and insert the given data into the tree.
   * Returns the new node pointer (the standard way to communicate a changed pointer back to the
   * caller).
   */
  private Node<E> add(Node<E> current, E value) {
    if (current == null) {
      current = new Node<>(value);
    } else if (current.value.hashCode() <= value.hashCode()) {

      current.rightChild = add(current.rightChild, value);

    } else {
      current.leftChild = add(current.leftChild, value);
    }

//    else {g
//      current = rotarNodeToRight(current)
//    }
    current.balanceFactor = height(current.leftChild) - height(current.rightChild);
    if (getBalanceFactor(current.leftChild) - getBalanceFactor(current.rightChild) == 2) {
      current = rotateNodeToLeft(current);
    }
    return current;
  }


  /**
   * Prints the node values in the "inorder" order. Uses a recursive helper to do the traversal.
   */
  public void printTree() {
    inorderTraversal(root);
  }

  private void inorderTraversal(Node<E> n) {
    if (n != null) {
      inorderTraversal(n.leftChild);
      visit(n);
      inorderTraversal(n.rightChild);
    }
  }

  private void visit(Node<E> n) {
    System.out.println(n.value);
  }

  public Node<E> rotateNodeToRight(Node currentNode) {
    Node rotedNode = currentNode.rightChild;
    currentNode.rightChild = rotedNode.leftChild;
    rotedNode.leftChild = currentNode;
    currentNode.balanceFactor = Math
        .max(getBalanceFactor(currentNode.leftChild), getBalanceFactor(currentNode.rightChild)) + 1;
    rotedNode.balanceFactor = Math
        .max(getBalanceFactor(currentNode.leftChild), getBalanceFactor(currentNode.rightChild)) + 1;
    return rotedNode;
  }

  public Node<E> rotateNodeToLeft(Node currentNode) {
    Node rotedNode = currentNode.leftChild;
    currentNode.leftChild = rotedNode.rightChild;
    rotedNode.rightChild = currentNode;
    currentNode.balanceFactor = Math
        .max(getBalanceFactor(currentNode.leftChild), getBalanceFactor(currentNode.rightChild)) + 1;
    rotedNode.balanceFactor = Math
        .max(getBalanceFactor(currentNode.leftChild), getBalanceFactor(currentNode.rightChild)) + 1;
    return rotedNode;
  }

  int getBalanceFactor(Node node) {
    if (node == null) {
      return -1;
    }
    return node.balanceFactor;
  }

  private int height(Node node) {
    if (node == null) {
      return (-1);
    }
    int leftHeight = height(node.leftChild);
    int rightHeight = height(node.rightChild);
    return (Math.max(leftHeight, rightHeight) + 1);

  }

}


