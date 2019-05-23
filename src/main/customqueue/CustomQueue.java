package customqueue;

import customdoublylist.CustomList;
import customdoublylist.IList;

public class CustomQueue<E> implements IQueue<E> {

  private IList<E> queue;

  /**
   * Constructor method.
   */
  public CustomQueue() {
    queue = new CustomList<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(E value) {
    queue.addLast(value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public E remove() {
    E value = queue.getFirst();
    queue.removeFirst();
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public E peek() {
    return queue.getFirst();
  }

}

