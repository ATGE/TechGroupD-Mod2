package customtree;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class CustomTreeTest {

  /**
   * test for adding String element at the tree.
   */
  @Test
  public void add() {
    CustomTree<String> tree = new CustomTree<>();
    tree.add("root", null);
    int start = 0;
    int end = 100;
    List<String> expectedChildrenData = IntStream.rangeClosed(start, end).mapToObj(String::valueOf)
        .collect(Collectors.toList());
    for (String data : expectedChildrenData) {
      tree.add(data, tree);

    }
    List<String> actualChildrenData = new ArrayList<>();
    for (CustomTree<String> child : tree.children) {
      actualChildrenData.add(child.data);
    }
    assertThat(actualChildrenData, is(expectedChildrenData));
    assertEquals(actualChildrenData, expectedChildrenData);
    assertEquals("root", tree.data);
  }

  /**
   * test for adding children at the tree.
   */
  @Test
  public void addChildren() {
    CustomTree<String> tree = new CustomTree<>();
    tree.add("root data", null);
    tree.addChild("child 1");
    tree.addChild("child 2");
    tree.addChild("child 3");
    tree.hasChildren();
  }

  /**
   * test for adding a child to sub-tree of a tree.
   */
  @Test
  public void addChildToSubTree() {
    CustomTree<String> tree = new CustomTree<>();
    tree.add("root data", null);
    tree.addChild("child 1");
    tree.addChild("child 2");
    CustomTree child1 = tree.getChild(0, tree);
    tree.add("child 1.1", child1);
    assertTrue(child1.hasChildren());
    CustomTree child11 = tree.getChild(0, child1);
    assertEquals("child 1.1", child11.data);
    assertEquals(false, child11.hasChildren());
  }

  /**
   * test for getting the representation as String of the tree.
   */
  @Test
  public void testToString() {
    CustomTree<String> tree = new CustomTree<>();
    tree.add("root 0", null);
    tree.addChild("child 1");
    tree.addChild("child 2");
    tree.addChild("child 3");
    CustomTree child1 = tree.getChild(0, tree);
    CustomTree child2 = tree.getChild(1, tree);
    CustomTree child3 = tree.getChild(2, tree);
    tree.add("child 1.1", child1);
    CustomTree child11 = tree.getChild(0, child1);
    tree.add("child 1.1.1", child11);
    tree.add("child 2.1", child2);
    tree.add("child 3.1", child3);
    final String expectedValue
        = "root 0" + System.lineSeparator()
        + "child 1" + System.lineSeparator()
        + "child 1.1" + System.lineSeparator()
        + "child 1.1.1" + System.lineSeparator()
        + "child 2" + System.lineSeparator()
        + "child 2.1" + System.lineSeparator()
        + "child 3" + System.lineSeparator()
        + "child 3.1" + System.lineSeparator();
    assertEquals(expectedValue, tree.toString());
    System.out.println(tree.toString());
  }
}
