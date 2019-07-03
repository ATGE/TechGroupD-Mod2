package customtree;

import java.util.ArrayList;
import java.util.List;

public class CustomTree<T> {

  protected T data;
  protected List<CustomTree<T>> children;

  public CustomTree() {
    this.children = new ArrayList<>();
  }

  public void addChild(T data) {
    CustomTree<T> newChild = new CustomTree();
    newChild.data = data;
    this.children.add(newChild);
  }

  public void add(T data, CustomTree parent) {
    if (parent == null) {
      this.data = data;
    } else {
      if (parent == this) {
        addChild(data);
      } else {
        add(data, parent, children);
      }
    }
  }


  private void add(T data, CustomTree parent, List<CustomTree<T>> children) {

    for (CustomTree tree : children) {
      if (parent == tree) {
        tree.addChild(data);
      } else {
        if (tree.hasChildren()) {
          tree.add(data, parent, children);
        }
      }
    }
  }

  public boolean hasChildren() {
    return children.size() > 0;
  }

  public CustomTree<T> getChild(int index, CustomTree<T> parent) {
    if (parent == null) {
      return children.get(index);
    } else {
      return getChild(index, parent, this);
    }
  }

  public CustomTree<T> getChild(int index, CustomTree<T> parent, CustomTree<T> tree) {
    if (parent == tree) {
      return children.get(index);
    } else {
      for (CustomTree<T> child : children) {
        if (parent == child) {
          return child.children.get(index);
        } else {
          if (tree.hasChildren()) {
            return getChild(index, parent, child);
          }
        }
      }
      return null;
    }
  }

}
