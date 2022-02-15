package org.cr.leetcode.slidingwindow;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/15
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class _76MinimumWindowSubstring {

    /**
     * 1. Use two pointers: start and end to represent a window.
     * 2. Move end to find a valid window.
     * 3. When a valid window is found, move start to find a smaller window.
     * 链接: https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
     *
     * 不同问题counter和map数组的定义不同
     */
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        char[] arr2 = t.toCharArray();
        for (char ch : arr2) {
            map[ch]++;
        }
        char[] arr = s.toCharArray();
        // counter represents the number of chars of t to be found in s.
        int counter = t.length(), left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        // Move end to find a valid window.
        while (right < s.length()) {
            // If char in s exists in t, decrease counter
            if (map[arr[right]] > 0) counter--;
            // Decrease m[s[end]]. If char does not exist in t, m[s[end]] will be negative.
            map[arr[right]]--;
            right++;
            // When we found a valid window, move start to find smaller window.
            while (counter == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }
                map[arr[left]]++;
                // When char exists in t, increase counter.
                if (map[arr[left]] > 0) counter++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
