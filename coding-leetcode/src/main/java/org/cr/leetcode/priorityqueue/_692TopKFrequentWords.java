package org.cr.leetcode.priorityqueue;

import java.util.*;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/10
 *
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i] consists of lowercase English letters.
 * k is in the range [1, The number of unique words[i]]
 *
 *
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */
public class _692TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> Objects.equals(o1.getValue(), o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue()
        );
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()) {
            res.add(0, priorityQueue.poll().getKey());
        }
        return res;
    }
}
