package org.cr.leetcode.slidingwindow;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/22
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class _567PermutationInString {

    /**
     * Óë{@link _76MinimumWindowSubstring} ºÍ {@link _438FindAllAnagramsInAString} ÀàËÆ
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[128];
        for (char ch : s1.toCharArray()) {
            map[ch]++;
        }
        int start = 0, end = 0, counter = s1.length();
        while (end < s2.length()) {
            if (map[s2.charAt(end)] > 0) counter--;
            map[s2.charAt(end)]--;
            end++;

            while (counter == 0) {
                if (end - start == s1.length()) {
                    return true;
                }
                map[s2.charAt(start)]++;
                if (map[s2.charAt(start)] > 0) counter++;
                start++;
            }
        }
        return false;
    }
}
