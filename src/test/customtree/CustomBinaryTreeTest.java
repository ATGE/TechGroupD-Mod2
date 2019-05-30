package customtree;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

public class CustomBinaryTreeTest {

  private CustomBinaryTree customBinaryTree;


  /**
   * test for adding Integers element at the tree.
   */
  @Test
  public void add() {
    customBinaryTree = new CustomBinaryTree<Integer>();
    customBinaryTree.add(1);
    customBinaryTree.add(0);
    customBinaryTree.add(2);
    assertEquals(1, customBinaryTree.root.value);
    assertEquals(0, customBinaryTree.root.leftChild.value);
    assertEquals(2, customBinaryTree.root.rightChild.value);
  }

  /**
   * test for printing String element in the tree.
   */
  @Test
  public void printTree() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    customBinaryTree = new CustomBinaryTree<String>();
    customBinaryTree.add("1");
    customBinaryTree.add("3");
    customBinaryTree.add("2");
    customBinaryTree.printTree();
    final String expectedValue
        = "1" + System.lineSeparator()
        + "2" + System.lineSeparator()
        + "3" + System.lineSeparator();
    assertEquals(expectedValue, outContent.toString());

  }

}

