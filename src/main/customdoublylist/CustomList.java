package customdoublylist;

/**
 * CustomList, doubly-linked list implementation of the {@code IList} interface.
 *
 * @param <E> the type of elements held in this collection
 */
public class CustomList<E> implements IList<E> {

  private Node<E> head;
  private Node<E> tail;

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(E value) {
    Node<E> last = tail;
    Node<E> newNode = new Node<>(value);
    newNode.previous = tail;
    tail = newNode;
    if (last == null) {
      head = newNode;
    } else {
      last.next = newNode;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addFirst(E value) {
    Node<E> first = head;
    Node<E> newNode = new Node<>(value);
    newNode.next = head;
    head = newNode;
    if (first == null) {
      tail = newNode;
    } else {
      first.previous = newNode;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addLast(E value) {
    add(value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(int index, E value) {
    Node<E> newNode = new Node(value);
    Node<E> currentNode = head;
    for (int i = 0; i < index - 1; i++) {
      currentNode = currentNode.next;
    }
    newNode.next = currentNode.next;
    newNode.previous = currentNode;
    currentNode.next = newNode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void remove(int index) {
    Node<E> currentNode = head;
    for (int i = 0; i < index - 1; i++) {
      currentNode = currentNode.next;
    }
    currentNode.next = currentNode.next.next;
    currentNode.next.previous = currentNode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public E get(int index) {
    Node<E> currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }
    return currentNode.value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void printList() {
    Node<E> currentNode = head;
    while (currentNode != null) {
      System.out.println(currentNode.value);
      currentNode = currentNode.next;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removeLast() {
    if (head != null) {
      if (tail != head) {
        tail = tail.previous;
        tail.next = null;
      } else {
        head = tail = null;
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removeFirst() {
    if (head != tail) {
      head = head.next;
      head.previous = null;
    }
    if (head == null) {
      tail = null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public E getFirst() {
    if (head != null) {
      return head.value;
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public E getLast() {
    if (tail != null) {
      return tail.value;
    }
    return null;
  }

}
