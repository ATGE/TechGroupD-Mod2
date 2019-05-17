package customdoublylist;

/**
 * Node implementation, contain data and also may link to other nodes.
 *
 * @param <E> the type of element
 */
public class Node<E> {

  E value;
  Node<E> next;
  Node<E> previous;

  /**
   * Constructs a Node for containing the data.
   *
   * @param value is the data
   */
  public Node(E value) {
    this.value = value;
    this.next = null;
    this.previous = null;
  }
}
