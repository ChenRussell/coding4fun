package org.cr.leetcode.linkedlist;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/18
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class _24SwapNodesinPairs {

    /**
     * 思路：first跟second交换，然后指针移动，改变指向
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode resHead = head.next;
        ListNode first = head, second = head.next;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;

            ListNode pre = first;
            first = first.next;
            if (first != null) {
                second = first.next;
            } else {
                second = null;
            }
            if (second != null) {
                pre.next = second;
            } else {
                pre.next = first;
            }
        }

        if (resHead == null) {
            return head;
        } else {
            return resHead;
        }
    }

    public static void main(String[] args) {
        _24SwapNodesinPairs swapNodesinPairs = new _24SwapNodesinPairs();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        second.next = null;
        ListNode res = swapNodesinPairs.swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
