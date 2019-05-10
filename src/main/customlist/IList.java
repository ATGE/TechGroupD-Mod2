package customlist;

/**
 * An ordered collection . The user of this interface has precise control over where in the list
 * each element is inserted.
 */
public interface IList<E> {

  /**
   * Inserts the specified element at the list.
   *
   * @param value the element to add
   */
  void add(E value);


  /**
   * Inserts the specified element at the beginning of this list.
   *
   * @param value the element to add
   */
  void addFirst(E value);

  /**
   * Appends the specified element to the end of this list.
   *
   * @param value the element to add
   */
  void addLast(E value);

  /**
   * Inserts the specified element at the specified position in this list.
   *
   * @param index index at which the specified element is to be inserted
   * @param value element to be inserted
   */
  void add(int index, E value);

  /**
   * Removes the element at the specified position in this list.
   *
   * @param index the index of the element to be removed
   */
  void remove(int index);

  /**
   * Removes the first element from this list.
   */
  void removeFirst();

  /**
   * Removes the last element from this list.
   */
  void removeLast();

  /**
   * Prints the elements of the list.
   */
  void printList();

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index index of the element to return
   * @return the element at the specified position in this list
   */
  E get(int index);

  /**
   * Returns the first element in this list.
   *
   * @return the first element in this list
   */
  E getFirst();

  /**
   * Returns the last element in this list.
   *
   * @return the last element in this list
   */
  E getLast();


}
