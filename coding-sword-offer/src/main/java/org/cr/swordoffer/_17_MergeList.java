package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/3/14
 * <p>
 * ��Ŀ����
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */
public class _17_MergeList {
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
        _17_MergeList mergeList = new _17_MergeList();
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
