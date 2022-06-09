package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/01/26
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class _148SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, slow = head, fast = head;

        // step 1. cut the list to two halves
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // step 2. sort each half
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        // step 3. merge head1 and head2
        return merge(head1, head2);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode fakeHead = new ListNode(-1);
        ListNode p = fakeHead;
        while (first != null && second != null) {
            if (first.val < second.val) {
                p.next = first;
                first = first.next;
            } else {
                p.next = second;
                second = second.next;
            }
            p = p.next;
        }
        if (first != null) p.next = first;
        if (second != null) p.next = second;
        return fakeHead.next;
    }
}
