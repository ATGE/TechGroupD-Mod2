package customdoublylist;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

public class CustomListTest {

  private CustomList customList;

  /**
   * Setup.
   */
  @Before
  public void setUp() {
    customList = new CustomList();
  }

  /**
   * test for adding an element at the list.
   */
  @Test
  public void testAdd() {
    customList.add(new Integer(1));
    final Integer expectedValue = new Integer(1);
    assertEquals(expectedValue, customList.getFirst());

  }

  /**
   * test for inserting the specified element at the beginning of this list.
   */
  @Test
  public void testAddFirst() {
    customList.add("1");
    customList.addFirst("2");
    final String expectedValue = "2";
    assertEquals(expectedValue, customList.getFirst());
  }

  /**
   * Test appends the specified element to the end of this list.
   */
  @Test
  public void testAddLast() {
    customList.add(new Integer(1));
    customList.addLast(new Integer(2));
    final int expectedValue = 2;
    assertEquals(expectedValue, customList.getLast());
  }

  /**
   * Test inserting the specified element at the specified position in this list.
   */
  @Test
  public void testAddByIndex() {
    final int index = 1;
    final Integer expectedValue = 2;
    customList.add(new Integer(1));
    customList.add(new Integer(3));
    customList.add(index, new Integer(2));
    assertEquals(expectedValue, customList.get(index));
  }

  /**
   * Test removing the specified element at the specified position in this list.
   */
  @Test
  public void testRemoveByIndex() {
    final int index = 1;
    final Integer expectedValue = 3;
    customList.add(new Integer(1));
    customList.add(new Integer(2));
    customList.add(new Integer(3));
    customList.remove(index);
    assertEquals(expectedValue, customList.get(index));
  }

  /**
   * Test for printing the element of the list.
   */
  @Test
  public void testPrintList() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    customList.add("1");
    customList.add("2");
    customList.add("3");
    customList.printList();
    final String expectedValue
        = "1" + System.lineSeparator()
        + "2" + System.lineSeparator()
        + "3" + System.lineSeparator();
    assertEquals(expectedValue, outContent.toString());

  }

  /**
   * test for removing the last element  in this list.
   */
  @Test
  public void testRemoveLast() {
    customList.add("1");
    customList.add("2");
    customList.add("3");
    customList.removeLast();
    final String expectedValue = "2";
    assertEquals(expectedValue, customList.getLast());
  }

  /**
   * test for removing the first element  in this list.
   */
  @Test
  public void testRemoveFirst() {
    customList.add("1");
    customList.add("2");
    customList.add("3");
    customList.removeFirst();
    final String expectedValue = "2";
    assertEquals(expectedValue, customList.getFirst());
  }

  /**
   * testing returns the element at the specified position in this list.
   */
  @Test
  public void testGet() {
    customList.add("1");
    customList.add("2");
    customList.add("3");
    final String expectedValue1 = "1";
    final String expectedValue2 = "2";
    final String expectedValue3 = "3";
    assertEquals(expectedValue1, customList.get(0));
    assertEquals(expectedValue2, customList.get(1));
    assertEquals(expectedValue3, customList.get(2));
  }
}

