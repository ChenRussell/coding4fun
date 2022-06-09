package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/12
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class _84RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        while (head != null) {
            boolean headFlag = false;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                headFlag = true;
            }
            if (headFlag) head = head.next;
            else break;
        }
        ListNode pre = head;
        ListNode p = null;
        if (pre != null)
            p = pre.next;

        while (p != null) {
            boolean flag = false;
            while (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
                flag = true;
            }
            if (flag) {
                pre.next = p.next;
                p = p.next;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates_voted(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0); // 定义一个fake head，可统一后续的处理逻辑
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
}
