package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 2018/3/12
 * <p>
 * 题目描述
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class _16_ReverseList {

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

    // Method2
    public ListNode reverseList2(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            ListNode temp = head.next;  // 先将next节点存储起来
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }

    public static void main(String[] args) {
        _16_ReverseList obj = new _16_ReverseList();
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
