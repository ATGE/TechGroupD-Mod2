package customlist;

public class CustomList<E> implements IList<E> {

  Node<E> head;
  Node<E> tail;

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

  @Override
  public void addFirst(E value) {
    Node<E> newNode = new Node(value);
    newNode.next = head;
    head = newNode;
    if (newNode.next == null) {
      tail = newNode;
    }
  }

  @Override
  public void addLast(E value) {
    add(value);
  }

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

  @Override
  public void remove(int index) {
    Node currentNode = head;
    for (int i = 0; i < index - 1; i++) {
      currentNode = currentNode.next;
    }
    currentNode.next = currentNode.next.next;
  }

  @Override
  public E get(int index) {
    Node<E> currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }
    return currentNode.value;
  }


  @Override
  public void printList() {
    Node<E> currentNode = head;
    while (currentNode != null) {
      System.out.println(currentNode.value);
      currentNode = currentNode.next;
    }
  }

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

  @Override
  public void removeFirst() {
    if (head != null) {
      head = head.next;
    }
    if (head == null) {
      tail = null;
    }
  }

  @Override
  public E getFirst() {
    if (head != null) {
      return head.value;
    }
    return null;
  }

  @Override
  public E getLast() {
    if (tail != null) {
      return tail.value;
    }
    return null;
  }

}
