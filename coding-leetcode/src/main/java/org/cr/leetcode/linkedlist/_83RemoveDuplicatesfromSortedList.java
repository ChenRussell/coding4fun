package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/12
 * <p>
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class _83RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            while (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

    public ListNode deleteDuplicates_voted(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates_voted(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
