package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-4-22
 */
public class _57DeleteDuplication {

    public static ListNode deleteDuplication(ListNode pHead) {

        ListNode p = pHead, pre = pHead;
        if (p == null) return null;
        while (p.next != null) {
            ListNode pf = p;
            boolean flag = false;
            while (pf.val == p.next.val) {
//                if (pre == pHead) pHead = p.next.next;
//                else pre.next = p.next.next;
//                pre = p;
                p = p.next; // 走到不相等的元素
                flag = true;
            }
            if (flag){
                p = p.next;
                pre.next = p;
            }
            else {

                pre = p;
                p = p.next;
            }
            if (p == null) break;
        }
        return pHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(3);
        ListNode res = deleteDuplication(node);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
