package org.cr.leetcode.linkedlist;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/01
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class _234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        if (len == 1) return true;
        p = head;
        int halfLen = len / 2;
        while (halfLen-1 > 0) {
            p = p.next;
            halfLen--;
        }
        ListNode firstStart = head, firstEnd = p, secondStart = p.next;
        if (len %2 == 1) secondStart = secondStart.next;
        ListNode tail = null;
        ListNode end = firstEnd.next;
        while (firstStart != end) {
            ListNode tmp = firstStart.next;
            firstStart.next = tail;
            tail = firstStart;
            firstStart = tmp;
        }
        while (firstEnd != null && secondStart != null) {
            if (firstEnd.val != secondStart.val) return false;
            firstEnd = firstEnd.next;
            secondStart = secondStart.next;
        }
        return true;
    }

    public boolean isPalindrome_voted(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) { // 使用快慢指针定位节点更加优雅
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow); // 对后半段做反转
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        _234PalindromeLinkedList obj = new _234PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = null;
        System.out.println(obj.isPalindrome(head));
    }
}
