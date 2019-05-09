package customlist;

public class Node<E> {

  E value;
  Node next;

  public Node(E value) {
    this.value = value;
    this.next = null;
  }
}
