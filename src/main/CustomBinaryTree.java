public class CustomBinaryTree<T> {

  class Node<T> {

    T value;
    Node leftChild = null;
    Node rightChild = null;

    Node(T value) {
      this.value = value;
    }
  }

  public CustomBinaryTree() {

  }

  protected Node<T> root = null;

  public void add(T value) {
    root = add(root, value);
  }

  private Node<T> add(Node<T> current, T value) {
    if (current == null) {
      current = new Node<>(value);
    } else if (current.value.hashCode() <= value.hashCode()) {

      current.rightChild = add(current.rightChild, value);
    } else {
      current.leftChild = add(current.leftChild, value);
    }

    return current;
  }
}


