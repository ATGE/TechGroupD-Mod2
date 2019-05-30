import static org.junit.Assert.*;

import org.junit.Test;

public class CustomBinaryTreeTest {

  @Test
  public void add() {
    CustomBinaryTree customBinaryTree = new CustomBinaryTree();
    customBinaryTree.add(1);
    customBinaryTree.add(0);
    customBinaryTree.add(2);
    assertEquals(1, customBinaryTree.root.value);
    assertEquals(0, customBinaryTree.root.leftChild.value);
    assertEquals(2, customBinaryTree.root.rightChild.value);
  }
}