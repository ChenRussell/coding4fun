package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/18
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning
 * and the kth node from the end (the list is 1-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 * Example 3:
 *
 * Input: head = [1], k = 1
 * Output: [1]
 * Example 4:
 *
 * Input: head = [1,2], k = 1
 * Output: [2,1]
 * Example 5:
 *
 * Input: head = [1,2,3], k = 2
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */
public class _1721SwappingNodesinaLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode p = head;
        int count = 1;
        while (p != null && count < k) {
            p = p.next;
            count++;
        }
        if (p == null) return head;
        ListNode first = p;
        ListNode kNode = p;
        ListNode second = head;
        while (kNode.next != null) {
            kNode = kNode.next;
            second = second.next;
        }
        if (first != second) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        return head;
    }
}
