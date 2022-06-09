package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/17
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
 */
public class _19RemoveNthNodeFromEndofList {

    /**
     * 找到第n个节点，然后两个指针一起移动
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fakeHead = new ListNode(-1);
            fakeHead.next = head;
            ListNode pre = fakeHead, p = head;
            int count = 1;
            while (p != null && count < n) {
                p = p.next;
                count++;
            }
            if (p == null) return head;
            ListNode kNode = p;
            p = head;
            while (kNode.next != null) {
                kNode = kNode.next;
                p = p.next;
                pre = pre.next;
            }
            pre.next = p.next;
            return fakeHead.next;
    }
}
