package customlist;

/**
 * CustomList ,linked list implementation of the {@code IList} interface.
 */
public class CustomList<E> implements IList<E> {

  Node<E> head;
  Node<E> tail;

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(E value) {
    Node<E> newNode = new Node(value);
    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addFirst(E value) {
    Node<E> newNode = new Node(value);
    newNode.next = head;
    head = newNode;
    if (newNode.next == null) {
      tail = newNode;
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
    currentNode.next = newNode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void remove(int index) {
    Node currentNode = head;
    for (int i = 0; i < index - 1; i++) {
      currentNode = currentNode.next;
    }
    currentNode.next = currentNode.next.next;
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
        Node<E> currentNode = head;
        while (currentNode.next != tail) {
          currentNode = currentNode.next;
        }
        tail = currentNode;
        currentNode.next = null;
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
    if (head != null) {
      head = head.next;
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
