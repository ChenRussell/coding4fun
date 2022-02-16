package org.cr.leetcode.priorityqueue;

import java.util.PriorityQueue;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/16
 *
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * You must find a solution with a memory complexity better than O(n2).
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * Example 2:
 *
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
 * 1 <= k <= n2
 *
 *
 * Follow up:
 *
 * Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
 * Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
 */
public class _378KthSmallestElementinaSortedMatrix {

    /**
     * 与{@link _23MergeKSortedList}类似，可以把每列视作为一个链表
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>();
        int len = Math.min(k, matrix[0].length);
        for (int i = 0; i < len; i++) {
            priorityQueue.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple poll = priorityQueue.poll();
            if (poll.x + 1 == matrix.length) continue;
            priorityQueue.offer(new Tuple(poll.x + 1, poll.y, matrix[poll.x + 1][poll.y]));
        }
        return priorityQueue.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}
