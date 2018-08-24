package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-4-17
 * <p>
 * 题目描述
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class _56EntryNodeOfLoop {

    static public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode slowNode = pHead;
        ListNode fastNode = pHead;
        // 当只有一个节点时直接返回null
        if (fastNode.next == null) return null;

        // 找到相遇点
        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (fastNode == null) break;
            if (fastNode == slowNode) break;
        }

        if (fastNode == null) return null;

        slowNode = pHead;
        // 起点到入口的距离等于相遇点到入口的距离
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
