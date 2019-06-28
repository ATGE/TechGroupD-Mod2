package customtree;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    assertEquals(1, customBinaryTree.root.value);
  }

  /**
   * test for printing String element in the tree.
   */
  @Test
  public void printTree() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    customBinaryTree = new CustomBinaryTree<String>();
    customBinaryTree.add("0");
    customBinaryTree.printTree();
    final String expectedValue
        = "0" + System.lineSeparator();
    assertEquals(expectedValue, outContent.toString());

  }

  /**
   * test for height of the tree , if binary tree is self-balanced, has height should be less to
   * LOG2(N+1) , for N = number of nodes .
   */
  @Test
  public void addHeightRight() {
    customBinaryTree = new CustomBinaryTree<Integer>();
    final int nodeNumber = 16;
    for (int nodeValue = 0; nodeValue < nodeNumber; nodeValue++) {
      customBinaryTree.add(nodeValue);
    }
    assertEquals(4, customBinaryTree.height());
  }

  /**
   * test for deleting element at the tree.
   */
  @Test
  public void delete() {
    customBinaryTree = new CustomBinaryTree<Integer>();
    customBinaryTree.add(1);
    customBinaryTree.delete(1);
  }

}
