package customtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomTree<T> {

  protected T data;
  protected CustomTree<T>[] children;

  public CustomTree() {
    this.children = new CustomTree[0];
  }

  /**
   * Adds a child at the tree.
   */
  public void addChild(T data) {
    CustomTree<T> newChild = new CustomTree();
    newChild.data = data;
    addToChildren(newChild);
  }

  private void addToChildren(CustomTree<T> newChild) {
    int currentChildrenLength = this.children.length;
    CustomTree<T>[] newChildren = Arrays.copyOf(this.children, currentChildrenLength + 1);
    newChildren[currentChildrenLength] = newChild;
    this.children = newChildren;

  }

  /**
   * Adds value to tree.
   *
   * @param data value to add
   * @param tree to add child
   */
  public void add(T data, CustomTree tree) {
    if (tree == null) {
      this.data = data;
    } else {
      if (tree == this) {
        addChild(data);
      } else {
        add(data, tree, this);
      }
    }
  }


  private void add(T data, CustomTree<T> parent, CustomTree<T> currentTree) {
    if (currentTree.hasChildren()) {
      for (CustomTree<T> tree : currentTree.children) {
        tree.add(data, parent);
      }
    }
  }

  /**
   * Retrieves true if tree has children.
   */
  public boolean hasChildren() {
    return children.length > 0;
  }

  /**
   * Gets the child by index with a specific parent.
   */
  public CustomTree<T> getChild(int index, CustomTree<T> parent) {
    if (parent == null) {
      return children[index];
    } else {
      return getChild(index, parent, this);
    }
  }

  private CustomTree<T> getChild(int index, CustomTree<T> parent, CustomTree<T> tree) {
    if (parent == tree) {
      return children[index];
    } else {
      for (CustomTree<T> child : children) {
        if (parent == child) {
          return child.children[index];
        } else {
          if (tree.hasChildren()) {
            return getChild(index, parent, child);
          }
        }
      }
      return null;
    }
  }

  /**
   * Retrieves tha data at the tree as String with line separator.
   *
   * @return String
   */
  public String toString() {
    StringBuilder treeBuilder = new StringBuilder();
    if (data == null) {
      return "";
    }
    treeBuilder.append(data.toString());
    treeBuilder.append(System.lineSeparator());
    if (hasChildren()) {
      for (CustomTree<T> tree : this.children) {
        treeBuilder.append(tree.toString());
      }
    }
    return treeBuilder.toString();
  }
}
