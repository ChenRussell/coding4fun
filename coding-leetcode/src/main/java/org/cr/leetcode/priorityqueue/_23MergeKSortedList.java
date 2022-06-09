package org.cr.leetcode.priorityqueue;

import org.cr.leetcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/10
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 */
public class _23MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.offer(node);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
        }
        return dummyNode.next;
    }
}
