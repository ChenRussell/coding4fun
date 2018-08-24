package com.nowcoder.SortAlgorithem;

/**
 * Created by ChenRui on 18-4-23
 *
 * 基于归并排序的单链表排序
 *
 * 归并排序的主要思想是将两个已经排好序的分段合并成一个有序的分段。
 * 除了找到中间节点的操作必须遍历链表外，其它操作与数组的归并排序基本相同。
 */
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class ListMergeSort {

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = getMid(head);  // 获取中间节点，将链表分为两段
        head1 = mergeSort(head1);   // 分别对两段链表进行排序
        head2 = mergeSort(head2);

        return merge(head1, head2);
    }

    // 通过快慢指针得到中间节点
    private ListNode getMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head.next;
        ListNode prev = head;

        while (true) {
            if (fast == null) break;
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;

            prev = slow;
            slow = slow.next;
        }
        prev.next = null;   // 将链表分为两段
        return slow;    // 第二段的头结点
    }

    private ListNode merge(ListNode head1, ListNode head2) {    // 合并两个有序链表
//        ListNode newhead = new ListNode(-1);    // 表头节点
//        ListNode newtail = newhead;

        ListNode newhead, newtail;

        // 比较第一个节点，将较小的你那个作为头结点
        if (head1.val <= head2.val) {
            newhead = head1;
            newtail = newhead;
            head1 = head1.next;
        } else {
            newhead = head2;
            newtail = newhead;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                newtail.next = head1;
                head1 = head1.next;
            } else {
                newtail.next = head2;
                head2 = head2.next;
            }

            newtail = newtail.next;
            newtail.next = null;
        }
        if (head1 != null) newtail.next = head1;
        if (head2 != null) newtail.next = head2;
        return newhead; // 返回链表头节点
    }

    public static void main(String[] args) {
        ListMergeSort obj = new ListMergeSort();
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(5);
        ListNode res = obj.mergeSort(node);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
