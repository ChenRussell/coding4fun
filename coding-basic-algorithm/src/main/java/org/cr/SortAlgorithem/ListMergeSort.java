package org.cr.SortAlgorithem;

/**
 * Created by ChenRui on 18-4-23
 *
 * ���ڹ鲢����ĵ���������
 *
 * �鲢�������Ҫ˼���ǽ������Ѿ��ź���ķֶκϲ���һ������ķֶΡ�
 * �����ҵ��м�ڵ�Ĳ���������������⣬��������������Ĺ鲢���������ͬ��
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
        ListNode head2 = getMid(head);  // ��ȡ�м�ڵ㣬�������Ϊ����
        head1 = mergeSort(head1);   // �ֱ�����������������
        head2 = mergeSort(head2);

        return merge(head1, head2);
    }

    // ͨ������ָ��õ��м�ڵ�
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
        prev.next = null;   // �������Ϊ����
        return slow;    // �ڶ��ε�ͷ���
    }

    private ListNode merge(ListNode head1, ListNode head2) {    // �ϲ�������������
//        ListNode newhead = new ListNode(-1);    // ��ͷ�ڵ�
//        ListNode newtail = newhead;

        ListNode newhead, newtail;

        // �Ƚϵ�һ���ڵ㣬����С�����Ǹ���Ϊͷ���
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
        return newhead; // ��������ͷ�ڵ�
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
