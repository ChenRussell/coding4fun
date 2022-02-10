package org.cr.leetcode.priorityqueue;

import java.util.*;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/08
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class _347TopKFrequentElements {

    // bucket sort
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        List<Integer> list = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int frequent = entry.getValue();
            if (bucket[frequent] == null) {
                bucket[frequent] = new ArrayList<>();
            }
            bucket[frequent].add(entry.getKey());
        }
        for (int i = bucket.length - 1; i >= 0 && list.size() < k; i--) {
            if (bucket[i] != null) {
                list.addAll(bucket[i]);
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] topKFrequent_voted(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() - o2.getValue()
        );
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll().getKey();
        }
        return res;
    }
}
