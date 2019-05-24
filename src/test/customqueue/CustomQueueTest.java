package customqueue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class CustomQueueTest {

  private IQueue queue;

  /**
   * Setup.
   */
  @Before
  public void setUp() {
    queue = new CustomQueue();
  }

  /**
   * test for adding an element at the queue.
   */
  @Test
  public void add() {
    queue.add("test");
    final String expectedValue = "test";
    assertEquals(expectedValue, queue.peek());
  }

  /**
   * test for removing an element at the queue.
   */
  @Test
  public void remove() {
    queue.add("test1");
    queue.add("test2");
    final String expectedValue1 = "test1";
    final String expectedValue2 = "test2";
    assertEquals(expectedValue1, queue.remove());
    assertEquals(expectedValue2, queue.remove());

  }

  /**
   * test peek element at the queue.
   */
  @Test
  public void peek() {
    final Integer expectedValue1 = 123;
    final Integer expectedValue2 = 456;
    queue.add(new Integer(123));
    assertEquals(expectedValue1, queue.peek());
    queue.add(new Integer(456));
    queue.remove();
    assertEquals(expectedValue2, queue.peek());
  }
}
