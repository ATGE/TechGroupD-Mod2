import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

  public static void insertSorted(LinkedList<Integer> list, int value) {
    int index = 0;
    if (list != null) {
      if (list.isEmpty()) {
        list.add(value);
        return;
      }
      if (list.getLast().intValue() < value) {
        list.addLast(value);
        return;
      }

      while (index < list.size()) {
        if (list.get(index).intValue() >= value) {
          list.add(index, value);
          break;
        }
        index++;
      }
    }
  }


  public static void removeMaximumValues(LinkedList<String> list, int N) {

    if (list != null) {
      if (N > list.size()) {
        N = list.size();
      }
      if (N > 0) {
        LinkedList<String> cloneList;
        cloneList = (LinkedList) list.clone();
        removeDuplicated(cloneList);
        cloneList.sort(String::compareTo);
        list.removeAll(cloneList.subList(cloneList.size() - N, cloneList.size()));
      }
    }
  }

  private static void removeDuplicated(LinkedList<String> list) {
    LinkedList<String> newList = new LinkedList<>();
    while (!list.isEmpty()) {
      String value = list.getLast();
      list.removeLast();
      newList.add(value);
      list.removeAll(newList);
    }
    list.addAll(newList);
  }

  public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
    boolean result = false;
    if (one != null && two != null &&
        !one.isEmpty() && !two.isEmpty() &&
        one.size() >= two.size()) {
      for (int index = 0; index <= one.size() - two.size(); index++) {
        if (two.equals(one.subList(index, index + two.size()))) {
          result = true;
          break;
        }
      }
    }
    return result;
  }
}
