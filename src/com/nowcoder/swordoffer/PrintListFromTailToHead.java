package com.nowcoder.swordoffer;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class PrintListFromTailToHead {

    ArrayList<Integer> integers = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        // 此处不应该用while，递归就是用来代替循环的
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
//            System.out.println(listNode.val);
            integers.add(listNode.val);
        }
        return integers;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        System.out.println(listNode4.next);
        ArrayList<Integer> integers = new PrintListFromTailToHead().printListFromTailToHead(listNode1);
        integers.forEach(System.out::println);
    }
}
