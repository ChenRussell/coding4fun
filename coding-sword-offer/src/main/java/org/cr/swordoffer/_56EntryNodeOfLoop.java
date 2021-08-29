package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-4-17
 * <p>
 * ��Ŀ����
 * һ�������а����������ҳ�������Ļ�����ڽ�㡣
 */
public class _56EntryNodeOfLoop {

    static public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode slowNode = pHead;
        ListNode fastNode = pHead;
        // ��ֻ��һ���ڵ�ʱֱ�ӷ���null
        if (fastNode.next == null) return null;

        // �ҵ�������
        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (fastNode == null) break;
            if (fastNode == slowNode) break;
        }

        if (fastNode == null) return null; // ���������⣬���whileѭ������ΪfastNode.next==null�˳���ҲӦ��return null;

        slowNode = pHead;
        // ��㵽��ڵľ�����������㵽��ڵľ���
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return fastNode;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode res = entryNodeOfLoop(node);
        System.out.println(res.val);
    }
}
