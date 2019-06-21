package customtree;

public class CustomBinaryTree<E> {

  /**
   * The binary tree is built using this nested node class. Each node stores one data element, and
   * has left and right sub-tree pointer which may be null,  just used for storage; it does not have
   * any methods.
   */
  protected class Node<E> {

    E value;
    private int balance;
    private int height;
    Node leftChild = null;
    Node rightChild = null;
    Node parent = null;


    Node(E value) {
      this.value = value;
    }
  }

  protected Node<E> root;

  /**
   * Inserts the given data into the binary tree.
   */
  public void add(E value) {
    if (root == null) {
      root = new Node(value);
    } else {

      Node n = root;
      while (true) {
        Node parent = n;

        boolean goLeft = n.value.hashCode() > value.hashCode();
        n = goLeft ? n.leftChild : n.rightChild;

        if (n == null) {
          if (goLeft) {
            parent.leftChild = new Node(value);
            parent.leftChild.parent = parent;
          } else {
            parent.rightChild = new Node(value);
            parent.rightChild.parent = parent;
          }
          selfBalance(parent);
          break;
        }
      }
    }
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

  private void selfBalance(Node node) {
    updateBalance(node);

    if (node.balance == -2) {
      if (height(node.leftChild.leftChild) >= height(node.leftChild.rightChild)) {
        node = rotateRight(node);
      } else {
        node = rotateLeftRight(node);
      }

    } else if (node.balance == 2) {
      if (height(node.rightChild.rightChild) >= height(node.rightChild.leftChild)) {
        node = rotateLeft(node);
      } else {
        node = rotateRightLeft(node);
      }
    }

    if (node.parent != null) {
      selfBalance(node.parent);
    } else {
      root = node;
    }

  }

  private Node rotateLeft(Node node) {

    Node b = node.rightChild;
    b.parent = node.parent;

    node.rightChild = b.leftChild;

    if (node.rightChild != null) {
      node.rightChild.parent = node;
    }

    b.leftChild = node;
    node.parent = b;

    if (b.parent != null) {
      if (b.parent.rightChild == node) {
        b.parent.rightChild = b;
      } else {
        b.parent.leftChild = b;
      }
    }

    updateBalance(node, b);

    return b;
  }

  private Node rotateRight(Node node) {

    Node b = node.leftChild;
    b.parent = node.parent;

    node.leftChild = b.rightChild;

    if (node.leftChild != null) {
      node.leftChild.parent = node;
    }

    b.rightChild = node;
    node.parent = b;

    if (b.parent != null) {
      if (b.parent.rightChild == node) {
        b.parent.rightChild = b;
      } else {
        b.parent.leftChild = b;
      }
    }

    updateBalance(node, b);

    return b;
  }

  private Node rotateLeftRight(Node n) {
    n.leftChild = rotateLeft(n.leftChild);
    return rotateRight(n);
  }

  private Node rotateRightLeft(Node n) {
    n.rightChild = rotateRight(n.rightChild);
    return rotateLeft(n);
  }

  public int height() {
    return height(root);
  }

  private int height(Node n) {
    if (n == null) {
      return -1;
    }
    return n.height;
  }

  private void updateBalance(Node... nodes) {
    for (Node n : nodes) {
      updateHeight(n);
      n.balance = height(n.rightChild) - height(n.leftChild);
    }
  }

  private void updateHeight(Node node) {
    if (node != null) {
      node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }
  }

  /**
   * Deletes a value of the tree.
   */
  public void delete(E deleteValue) {
    if (root != null) {
      Node child = root;
      while (child != null) {
        Node node = child;
        child = deleteValue.hashCode() >= node.value.hashCode() ? node.rightChild : node.leftChild;
        if (deleteValue.hashCode() == node.value.hashCode()) {
          delete(node);
          return;
        }
      }
    }
  }

  private void delete(Node node) {
    if (node.leftChild == null && node.rightChild == null) {
      if (node.parent == null) {
        root = null;
      } else {
        Node parent = node.parent;
        if (parent.leftChild == node) {
          parent.leftChild = null;
        } else {
          parent.rightChild = null;
        }
        selfBalance(parent);
      }
      return;
    }

    if (node.leftChild != null) {
      Node child = node.leftChild;
      while (child.rightChild != null) {
        child = child.rightChild;
      }
      node.value = child.value;
      delete(child);
    } else {
      Node child = node.rightChild;
      while (child.leftChild != null) {
        child = child.leftChild;
      }
      node.value = child.value;
      delete(child);
    }
  }


}



