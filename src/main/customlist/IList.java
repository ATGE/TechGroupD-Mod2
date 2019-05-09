package customlist;

public interface IList<E> {

  void add(E value);

  void printList();

  void removeFirst();

  void removeLast();

  void addFirst(E value);

  void addLast(E value);

  void add(int index, E value);

  void remove(int index);

  E get(int index);

  E getFirst();

  E getLast();


}
