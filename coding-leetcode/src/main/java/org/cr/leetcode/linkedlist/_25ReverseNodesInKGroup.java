package org.cr.leetcode.linkedlist;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/10
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class _25ReverseNodesInKGroup {

    /**
     * First, build a function reverse() to reverse the ListNode between begin and end. See the explanation below:
     *
     *      * Reverse a link list between begin and end exclusively
     *      * an example:
     *      * a linked list:
     *      * 0->1->2->3->4->5->6
     *      * |           |
     *      * begin       end
     *      * after call begin = reverse(begin, end)
     *      *
     *      * 0->3->2->1->4->5->6
     *      *          |  |
     *      *      begin end
     *      * @return the reversed list's 'begin' node, which is the precedence of node end
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode begin = dummyNode, p = head;
        int count = 0;
        while (p != null) {
            count++;
            if (count % k == 0) {
                begin = reverse(begin, p.next);
                p = begin.next;
            } else {
                p = p.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin, curr = begin.next;
        ListNode first = curr;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        first.next = curr; // 1 -> 4
        begin.next = prev; // 0 -> 3
        return first;
    }
}
