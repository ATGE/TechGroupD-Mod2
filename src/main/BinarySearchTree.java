/**
 * Homework 4 - Binary Search Trees This assignment asks you to use and modify a binary search tree
 * (BST) implementation in order to determine whether a tree is balanced.
 */
public class BinarySearchTree<E extends Comparable<E>> {

  class Node {

    E value;
    Node leftChild = null;
    Node rightChild = null;

    Node(E value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
      if ((obj instanceof BinarySearchTree.Node) == false) {
        return false;
      }
      @SuppressWarnings("unchecked")
      Node other = (Node) obj;
      return other.value.compareTo(value) == 0
          && other.leftChild == leftChild && other.rightChild == rightChild;
    }
  }

  protected Node root = null;

  protected void visit(Node n) {
    System.out.println(n.value);
  }

  public boolean contains(E val) {
    return contains(root, val);
  }

  protected boolean contains(Node n, E val) {
    if (n == null) {
      return false;
    }

    if (n.value.equals(val)) {
      return true;
    } else if (n.value.compareTo(val) > 0) {
      return contains(n.leftChild, val);
    } else {
      return contains(n.rightChild, val);
    }
  }

  /**
   * Adds val to tree.
   */
  public boolean add(E val) {
    if (root == null) {
      root = new Node(val);
      return true;
    }
    return add(root, val);
  }

  protected boolean add(Node n, E val) {
    if (n == null) {
      return false;
    }
    int cmp = val.compareTo(n.value);
    if (cmp == 0) {
      return false; // this ensures that the same value does not appear more than once
    } else if (cmp < 0) {
      if (n.leftChild == null) {
        n.leftChild = new Node(val);
        return true;
      } else {
        return add(n.leftChild, val);
      }
    } else {
      if (n.rightChild == null) {
        n.rightChild = new Node(val);
        return true;
      } else {
        return add(n.rightChild, val);
      }
    }
  }

  /**
   * Remove val inn the tree.
   */
  public boolean remove(E val) {
    return remove(root, null, val);
  }

  protected boolean remove(Node n, Node parent, E val) {
    if (n == null) {
      return false;
    }

    if (val.compareTo(n.value) == -1) {
      return remove(n.leftChild, n, val);
    } else if (val.compareTo(n.value) == 1) {
      return remove(n.rightChild, n, val);
    } else {
      if (n.leftChild != null && n.rightChild != null) {
        n.value = maxValue(n.leftChild);
        remove(n.leftChild, n, n.value);
      } else if (parent == null) {
        root = n.leftChild != null ? n.leftChild : n.rightChild;
      } else if (parent.leftChild == n) {
        parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
      } else {
        parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
      }
      return true;
    }
  }

  protected E maxValue(Node n) {
    if (n.rightChild == null) {
      return n.value;
    } else {
      return maxValue(n.rightChild);
    }
  }

  /*********************************************
   *
   * IMPLEMENT THE METHODS BELOW!
   *
   *********************************************/

  /**
   * Given a value that is stored in the BST, it returns the corresponding Node that holds it. If
   * the value does not exist in this BST, this method return null.
   */
  public Node findNode(E val) {

    if (val == null) {
      return null;
    }
    return findNode(root, val);

  }

  private Node findNode(Node currentNode, E val) {
    Node result = null;
    if (currentNode != null) {
      if (currentNode.value.compareTo(val) == 0) {
        result = currentNode;
      } else if (currentNode.value.compareTo(val) > 0) {
        result = findNode(currentNode.leftChild, val);
      } else {
        result = findNode(currentNode.rightChild, val);
      }
    }
    return result;
  }

  /**
   * Given a value, this method return the “depth” of its Node. If the value is null or does not
   * exist in this BST, this method should return -1.
   */
  protected int depth(E val) {
    if (val == null || findNode(val) == null) {
      return -1;
    }
    return depth(val, root);
  }

  private int depth(E val, Node node) {
    int res = 0;
    if (node.value.compareTo(val) == 0) {
      return res;
    } else if (node.value.compareTo(val) > 0) {
      return depth(val, node.leftChild) + 1;
    } else {
      return depth(val, node.rightChild) + 1;
    }
  }

  /**
   * Given a value, this method should return the “height” of its Node. If the input value is null
   * or does not exist in this BST, this method should return -1.
   */
  protected int height(E val) {
    Node node = findNode(val);
    return height(node);

  }

  private int height(Node node) {
    if (node == null) {
      return (-1);
    }
    int leftHeight = height(node.leftChild);
    int rightHeight = height(node.rightChild);
    return (Math.max(leftHeight, rightHeight) + 1);

  }

  /**
   * Given a Node, return true if the absolute value of the difference in heights of its left and
   * right children is 0 or 1, and return false otherwise. If the Node is null or does not exist in
   * this BST, this method should return false.m node
   */
  protected boolean isBalanced(Node node) {

    if (node == null || !contains(node.value)) {
      return false;
    }

    return Math.abs(height(node.leftChild) - height(node.rightChild)) < 2;
  }

  /**
   * Returns true if isBalanced(Node) returns true for all Nodes in the tree. This method then
   * allows the user of the BST to determine whether the BST is balanced. Note that the root being
   * balanced
   */
  public boolean isBalanced() {
    return allNodesIsBalanced(root);
  }

  protected boolean allNodesIsBalanced(Node node) {
    if (node == null) {
      return false;
    }

    boolean result = isBalanced(node);

    if (node.leftChild != null) {
      result = result && allNodesIsBalanced(node.leftChild);
    }

    if (node.rightChild != null) {
      result = result && allNodesIsBalanced(node.rightChild);
    }

    return result;
  }

}
