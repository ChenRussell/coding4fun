package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/15
 *
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * Follow up: Could you do it in one pass?
 */
public class _92ReverseLinkedListII {

    /**
     * ˼·���ҵ�left��ǰ�ýڵ㣬right�ĺ��ýڵ㣬Ȼ���left->right������ͷ�巨
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pleft = head, pright = head;
        ListNode prePleft = new ListNode(-1);
        ListNode postPright = null;
        prePleft.next = pleft;
        int leftCount = left - 1;
        int rightCount = right - 1;
        while (pleft != null && leftCount-- > 0) {
            pleft = pleft.next;
            prePleft = prePleft.next;
        }
        if (pleft == null) return head;
        while (pright != null && rightCount-- > 0) {
            pright = pright.next;
        }
        if (pright != null) {
            postPright = pright.next;
        }

        ListNode tail = postPright;
        while (pleft != postPright) {
            ListNode temp = pleft.next;
            pleft.next = tail;
            tail = pleft;
            pleft = temp;
        }
        prePleft.next = tail;

        if (left > 1) {
            return head;
        } else {
            return tail;
        }
    }

    public ListNode reverseBetween_voted(ListNode head, int left, int right) {
        // ��Ϊͷ�ڵ��п��ܷ����仯��ʹ������ͷ�ڵ���Ա��⸴�ӵķ�������
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next; // ִ��˳����ǰ
            next.next = pre.next; // ������next.next = cur
            pre.next = next;
        }
        return dummyNode.next;
    }
}
