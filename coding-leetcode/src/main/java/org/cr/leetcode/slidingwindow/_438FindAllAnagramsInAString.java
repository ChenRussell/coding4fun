package org.cr.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/22
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
public class _438FindAllAnagramsInAString {

    /**
     * 与{@link _76MinimumWindowSubstring}类似
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[128];
        int start = 0, end = 0, counter = p.length();
        for (char ch : p.toCharArray()) {
            map[ch]++;
        }
        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) counter--;
            map[s.charAt(end)]--;
            end++;

            while (counter == 0) {
                // 与_76MinimumWindowSubstring只有这里不同
                if (end - start == p.length()) {
                    res.add(start);
                }
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0) counter++;
                start++;
            }
        }
        return res;
    }
}
