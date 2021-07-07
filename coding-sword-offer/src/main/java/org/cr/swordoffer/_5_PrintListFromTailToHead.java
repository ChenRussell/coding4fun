package org.cr.swordoffer;

import java.util.ArrayList;

/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class _5_PrintListFromTailToHead {

    ArrayList<Integer> integers = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        // �˴���Ӧ����while���ݹ������������ѭ����
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
        ArrayList<Integer> integers = new _5_PrintListFromTailToHead().printListFromTailToHead(listNode1);
        integers.forEach(System.out::println);
    }
}
