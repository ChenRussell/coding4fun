package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 2018/3/14
 * <p>
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode headNode,root;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            headNode = new ListNode(list1.val);
            list1 = list1.next;
            root = headNode;
        } else {
            headNode = new ListNode(list2.val);
            list2 = list2.next;
            root = headNode;
        }
        while (list1 != null && list2 != null) {
//            headNode = (list1.val)>(list2.val) ? list1 : list2;
            if (list1.val < list2.val) {
                headNode.next = list1;
                list1 = list1.next;
                headNode = headNode.next;
            } else {
                headNode.next = list2;
                list2 = list2.next;
                headNode = headNode.next;
            }
        }
        if (list1 != null) {
            headNode.next = list1;
        }else headNode.next = list2;
        return root;
    }

    public static void main(String[] args) {
        MergeList mergeList = new MergeList();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(4);
        ListNode merge = mergeList.Merge(listNode1, listNode2);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}
