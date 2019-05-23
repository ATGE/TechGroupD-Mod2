package customstack;

/**
 * The interface represents a last-in-first-out (LIFO) stack of objects.
 */
public interface IStack<E> {

  /**
   * Pushes an item onto the top of this stack.
   *
   * @param item the item to be pushed onto this stack.
   */
  void push(E item);

  /**
   * Removes the object at the top of this stack and returns that object as the value of this
   * function.
   *
   * @return The object at the top of this stack
   */
  E pop();

  /**
   * Looks at the object at the top of this stack without removing it from the stack.
   *
   * @return the object at the top of this stack
   */
  E peek();

}

