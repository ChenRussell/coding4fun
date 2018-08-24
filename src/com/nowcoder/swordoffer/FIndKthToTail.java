package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-3-12
 */

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}

public class FIndKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null) return null;
        if (k==0) return null;
        ListNode kNode = head;
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
            if (count > k) {
                kNode = kNode.next;
            }
        }
        if (count < k) return null;
        return kNode;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(1);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(7);
        ListNode kthToTail = new FIndKthToTail().findKthToTail(node, 8);
        System.out.println(kthToTail.val);
    }
}
