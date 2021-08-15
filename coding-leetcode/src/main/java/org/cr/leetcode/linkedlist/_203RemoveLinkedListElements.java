package org.cr.leetcode.linkedlist;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/15
 *
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * Example 2:
 *
 * Input: head = [], val = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class _203RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeNode = new ListNode(val + 1); // 定义一个fakeHead，统一处理逻辑，最后直接返回fakeHead.next
        fakeNode.next = head;
        ListNode p = head, preNode = fakeNode;
        while (p != null) {
            if (p.val == val) {
                preNode.next = p.next;
            } else {
                preNode = preNode.next;
            }
            p = p.next;
        }
        return fakeNode.next;
    }
}
