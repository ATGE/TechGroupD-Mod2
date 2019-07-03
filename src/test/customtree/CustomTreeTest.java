package customtree;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class CustomTreeTest {


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

  @Test
  public void addChildren() {
    CustomTree<String> tree = new CustomTree<>();
    tree.add("root data", null);
    tree.addChild("child 1");
    tree.addChild("child 2");
    tree.addChild("child 3");
  }
}