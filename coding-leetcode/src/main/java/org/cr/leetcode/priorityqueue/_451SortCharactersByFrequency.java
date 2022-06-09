package org.cr.leetcode.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/10
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 105
 * s consists of uppercase and lowercase English letters and digits.
 */
public class _451SortCharactersByFrequency {

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue()
        );
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            priorityQueue.offer(entry);
        }
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> poll = priorityQueue.poll();
            int repeatNum = poll.getValue();
            for (int i = 0; i < repeatNum; i++) {
                sb.append(poll.getKey());
            }
        }
        return sb.toString();
    }
}
