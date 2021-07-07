package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-4-17
 * <p>
 * ��Ŀ����
 * �������������ҳ����ǵĵ�һ��������㡣
 */
public class _37_FirstCommonNodesInLists {

    static public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1, node2 = pHead2;
        if (node1 == null || node2 == null) return null;
        int len1 = 0, len2 = 0;
        while (node1 != null) {
            len1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            len2++;
            node2 = node2.next;
        }
        node1 = pHead1;
        node2 = pHead2;
        if (len1 > len2) {
            int len = len1 - len2;
            while (len > 0) {
                node1 = node1.next;
                len--;
            }
            while (node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        } else if (len1 < len2) {
            int len = len2 - len1;
            while (len > 0) {
                node2 = node2.next;
                len--;
            }
            while (node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        } else {
            while (node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = node.next.next;
        ListNode res = FindFirstCommonNode(node, node2);
        System.out.println(res.val);
    }
}
