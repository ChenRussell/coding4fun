package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/17
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 *
 *
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 *
 *
 * Constraints:
 *
 * n == number of nodes in the linked list
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 */
public class _328OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode lastOdd = head, firstEven = head.next;
        ListNode pOdd = head, pEven = head.next;
        while (pOdd != null && pEven != null) {
            pOdd.next = pEven.next;
            if (pOdd.next != null) {
                pEven.next = pOdd.next.next;
            }
            // 偶数个节点时，记录lastOdd
            if (pOdd.next == null) {
                lastOdd = pOdd;
            }
            pOdd = pOdd.next;
            pEven = pEven.next;
        }
        // 奇数个节点时，记录lastOdd
        if (pOdd != null) lastOdd = pOdd;
        lastOdd.next = firstEven;
        return head;
    }

    // 思路是一样的
    public ListNode oddEvenList_voted(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
