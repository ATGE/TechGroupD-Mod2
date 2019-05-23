package customstack;

import customdoublylist.CustomList;

import customdoublylist.IList;


/**
 * The Stack class represents a last-in-first-out (LIFO) stack of objects.
 */
public class CustomStack<E> implements IStack<E> {

  private IList<E> stack;

  /**
   * Constructor method.
   */
  public CustomStack() {
    stack = new CustomList<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void push(E item) {
    stack.addLast(item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public E pop() {
    E item = stack.getLast();
    stack.removeLast();
    return item;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public E peek() {
    E item = stack.getLast();
    return item;
  }
}

