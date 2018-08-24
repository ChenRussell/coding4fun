package com.nowcoder.swordoffer;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by ChenRui on 2018/3/12
 * <p>
 * 题目描述
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList {

    // 头插法,需要一个空指针
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        ListNode p = null;
        while (head!=null) {
            p = head.next;
            head.next = tail;
            tail = head;
            head = p;
        }
        return tail;
    }

    public static void main(String[] args) {
        ReverseList obj = new ReverseList();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(6);

        ListNode node = obj.reverseList(listNode);
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);
        System.out.println(node.next.next.next.val);
        System.out.println(node.next.next.next.next.val);
    }
}
