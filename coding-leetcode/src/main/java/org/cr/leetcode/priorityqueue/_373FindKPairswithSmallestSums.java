package org.cr.leetcode.priorityqueue;

import java.util.*;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/16
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [[1,3],[2,3]]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in ascending order.
 * 1 <= k <= 104
 */
public class _373FindKPairswithSmallestSums {

    /**
     * 与{@link _378KthSmallestElementinaSortedMatrix}类似，先往堆里添加k个元素，然后取出一个最早的，再添加下一个
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> nums1[o[0]] + nums2[o[1]])));
        int len = Math.min(k, nums1.length);
        for (int i = 0; i < len; i++) {
            pq.offer(new int[]{i, 0});
        }
        //k = Math.min(k, nums1.length * nums2.length < 0 ? k+1 : nums1.length * nums2.length);
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] poll = pq.poll();
            res.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            if (poll[1] + 1 >= nums2.length) continue;
            pq.offer(new int[]{poll[0], poll[1] + 1});
        }
        return res;
    }
}
