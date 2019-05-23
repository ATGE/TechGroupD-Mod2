package customstack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class CustomStackTest {

  private IStack stack;

  /**
   * Setup.
   */
  @Before
  public void setUp() {
    stack = new CustomStack();
  }

  /**
   * test for adding an element at the stack.
   */
  @Test
  public void add() {
    stack.push("test");
    final String expectedValue = "test";
    assertEquals(expectedValue, stack.peek());
  }

  /**
   * test for removing an element at the stack.
   */
  @Test
  public void remove() {
    stack.push("test1");
    stack.push("test2");
    final String expectedValue1 = "test1";
    final String expectedValue2 = "test2";
    assertEquals(expectedValue2, stack.pop());
    assertEquals(expectedValue1, stack.pop());

  }

  /**
   * test peek element at the stack.
   */
  @Test
  public void peek() {
    final Integer expectedValue1 = 123;
    final Integer expectedValue2 = 456;
    stack.push(new Integer(123));
    assertEquals(expectedValue1, stack.peek());
    stack.push(new Integer(456));
    assertEquals(expectedValue2, stack.peek());
  }
}
