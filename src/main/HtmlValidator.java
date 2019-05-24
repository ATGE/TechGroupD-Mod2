import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

  /**
   * this method take as input a Queue of HtmlTags and return a Stack of HtmlTags that verifies the
   * correctness of the tag structure, according to the specification in the assignment
   * description.
   */
  public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

    Stack<HtmlTag> tagsStack = new Stack<>();
    Queue<HtmlTag> tagsQueue = new LinkedList<>(tags);

    while (!tagsQueue.isEmpty()) {
      HtmlTag tag = tagsQueue.remove();
      if (tag.isOpenTag()) {
        tagsStack.push(tag);
      } else {
        if (!tag.isSelfClosing()) {
          if (!tagsStack.isEmpty() && tag.matches(tagsStack.peek())) {
            tagsStack.pop();
          } else {
            if (tagsStack.empty()) {
              tagsStack = null;
            }
            break;
          }
        }
      }
    }

    return tagsStack;
  }
}







