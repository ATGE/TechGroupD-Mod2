package customtree;

import java.util.ArrayList;
import java.util.List;

public class CustomTree<T> {

  private T data;
  private List<CustomTree<T>> children;
  private CustomTree parent;

  public CustomTree(T data) {
    this.data = data;
    this.parent = null;
    this.children = new ArrayList<>();
  }

  public void add(T data, CustomTree parent) {
    if (parent == null) {
      this.data = data;
    } else {
      if (parent == this) {
        children.add(new CustomTree<>(data));
      } else {
        add(data, parent, children);
      }
    }
  }


  private void add(T data, CustomTree parent, List<CustomTree<T>> children) {

    for (CustomTree tree : children) {
      if (parent == tree) {
        tree.children.add(new CustomTree<>(data));
      } else {
        if (tree.children.isEmpty()) {
          add(data, tree, children);
        }
      }
    }

  }

}
