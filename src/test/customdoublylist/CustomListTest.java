package customdoublylist;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

public class CustomListTest {

  private CustomList<Integer> customList;

  /**
   * Setup.
   */
  @Before
  public void setUp() {
    customList = new CustomList();
  }

  /**
   * test for adding an element at the list
   */
  @Test
  public void testAdd() {
    customList.add(1);
    final int expectedValue = 1;
    assertEquals(expectedValue, customList.get(0).intValue());

  }

  /**
   * test for inserting the specified element at the beginning of this list.
   */
  @Test
  public void testAddFirst() {
    customList.add(1);
    customList.addFirst(2);
    final int expectedValue = 2;
    assertEquals(expectedValue, customList.getFirst().intValue());
  }

  /**
   * Test appends the specified element to the end of this list.
   */
  @Test
  public void testAddLast() {
    customList.add(1);
    customList.addLast(2);
    final int expectedValue = 2;
    assertEquals(expectedValue, customList.getLast().intValue());
  }

  /**
   * Test inserting the specified element at the specified position in this list.
   */
  @Test
  public void testAddByIndex() {
    customList.add(1);
    customList.add(3);
    customList.add(1, 2);
    final int expectedValue = 2;
    assertEquals(expectedValue, customList.get(1).intValue());
  }

  /**
   * Test removing the specified element at the specified position in this list.
   */
  @Test
  public void testRemoveByIndex() {
    customList.add(1);
    customList.add(2);
    customList.add(3);
    customList.remove(1);
    final int expectedValue = 3;
    assertEquals(expectedValue, customList.get(1).intValue());
  }

  /**
   * Test for printing the element of the list.
   */
  @Test
  public void testPrintList() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    customList.add(1);
    customList.add(2);
    customList.add(3);
    customList.printList();
    final String expectedValue =
        "1" + System.lineSeparator() +
            "2" + System.lineSeparator() +
            "3" + System.lineSeparator();
    assertEquals(expectedValue, outContent.toString());

  }

  /**
   * test for removing the last element  in this list
   */
  @Test
  public void testRemoveLast() {
    customList.add(1);
    customList.add(2);
    customList.add(3);
    customList.removeLast();
    final int expectedValue = 2;
    assertEquals(expectedValue, customList.getLast().intValue());
  }

  /**
   * test for removing the first element  in this list
   */
  @Test
  public void testRemoveFirst() {
    customList.add(1);
    customList.add(2);
    customList.add(3);
    customList.removeFirst();
    final int expectedValue = 2;
    assertEquals(expectedValue, customList.getFirst().intValue());
  }

  /**
   * testing returns the element at the specified position in this list.
   */
  @Test
  public void testGet() {
    customList.add(1);
    customList.add(2);
    customList.add(3);
    final int expectedValue1 = 1;
    final int expectedValue2 = 2;
    final int expectedValue3 = 3;
    assertEquals(expectedValue1, customList.get(0).intValue());
    assertEquals(expectedValue2, customList.get(1).intValue());
    assertEquals(expectedValue3, customList.get(2).intValue());
  }
}