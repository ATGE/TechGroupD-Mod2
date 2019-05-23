package customqueue;

public interface IQueue<E> {

  /**
   * Inserts the specified element into this queue.
   *
   * @param value the element to add
   */
  void add(E value);


  /**
   * Retrieves and removes the head of this queue.
   *
   * @return the head of this queue
   */
  E remove();

  /**
   * Retrieves, but does not remove, the head of this queue, or returns {@code null} if this queue
   * is empty.
   *
   * @return the head of this queue, or {@code null} if this queue is empty
   */
  E peek();

}
