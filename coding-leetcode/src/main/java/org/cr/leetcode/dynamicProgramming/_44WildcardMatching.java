package org.cr.leetcode.dynamicProgramming;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/19
 * <p>
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'.
 */
public class _44WildcardMatching {

    /**
     * wrong answer
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (s.equals(p)) return true;

        boolean firstMatch = false;
        if (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*')) {
            firstMatch = true;
        }

        if (firstMatch) {
            if (p.charAt(0) == '*') {
                return true;
            }
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }

    /**
     * The original post has DP 2d array index from high to low, which is not quite intuitive.
     *
     * Below is another 2D dp solution. Ideal is identical.
     *
     * dp[i][j] denotes whether s[0....i-1] matches p[0.....j-1],
     *
     * First, we need to initialize dp[i][0], i= [1,m]. All the dp[i][0] should be false because p has nothing in it.
     *
     * Then, initialize dp[0][j], j = [1, n]. In this case, s has nothing, to get dp[0][j] = true, p must be '*', '**', '***',etc. Once p.charAt(j-1) != '*', all the dp[0][j] afterwards will be false.
     *
     * Then start the typical DP loop.
     *
     * Though this solution is clear and easy to understand. It is not good enough in the interview. it takes O(mn) time and O(mn) space.
     *
     * Improvement: 1) optimize 2d dp to 1d dp, this will save space, reduce space complexity to O(N). 2) use iterative 2-pointer.
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_2d_voted(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        _44WildcardMatching obj = new _44WildcardMatching();
        System.out.println(obj.isMatch("aa", "?a"));
    }
}
