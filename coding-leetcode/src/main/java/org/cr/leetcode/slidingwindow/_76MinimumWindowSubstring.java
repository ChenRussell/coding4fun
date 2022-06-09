package org.cr.leetcode.slidingwindow;

/**
 * @author russ
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
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }
        char[] arr = s.toCharArray();
        // counter represents the number of chars of t to be found in s.
        int counter = t.length(), start = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        // Move end to find a valid window.
        while (end < s.length()) {
            // If char in s exists in t, decrease counter
            if (map[arr[end]] > 0) counter--;
            // Decrease m[s[end]]. If char does not exist in t, m[s[end]] will be negative.
            map[arr[end]]--;
            end++;
            // When we found a valid window, move start to find smaller window.
            while (counter == 0) {
                if (end - start < minLen) {
                    minLen = end - start; // 这里不是end-start+1, 是因为上面执行了end++
                    minStart = start;
                }
                map[arr[start]]++;
                // When char exists in t, increase counter. 说明left指针右移后，少了一个在t里的字符
                if (map[arr[start]] > 0) counter++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
