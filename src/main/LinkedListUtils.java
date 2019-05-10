import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

  /**
   * This method assumes the input LinkedList is already sorted in non-descending order (i.e.,such
   * that each element is greater than or equal to the one that is before it, and inserts the input
   * int value into the correct location of the list. If the input LinkedList is null, this method
   * simply terminate.
   *
   * @param list to add the value.
   * @param value to add.
   */
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

  /**
   * This method removes all instances of the N largest values in the LinkedList. Because the values
   * are Strings, using compareTo method to find the largest elements, If the input LinkedList is
   * null or if N is non-positive, this method should simply return without any modifications to the
   * input LinkedList. Keep in mind that if any of the Nlargest values appear more than once in the
   * LinkedList, this method should return remove all instances, so it may remove more than N
   * elements overall. The other elements in the LinkedList should not be modified and their order
   * must not be changed.
   */
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

  /**
   * Removes all duplicates values contained in the list.
   *
   * @param list to remove duplicates values.
   */
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

  /**
   * This method determines whether any part of the first LinkedList contains all elements of the
   * second in the same order with no other elements in the sequence, i.e. it should return true if
   * the second LinkedList is a subsequence of the first, and false if it is not. The method should
   * return false if either input is null or empty.
   */
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
