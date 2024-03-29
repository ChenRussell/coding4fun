package org.cr.leetcode.dynamicProgramming;

/**
 * Created by ChenRui on 18-3-5
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (j - i + 1 > result.length())) {
                    result = s.substring(i, j + 1);
                }
            }
        }
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 */
public class _5LongestPalindromicSubstring {
    /**
     * 动态规划
     *
     * dp(i, j) represents whether s(i ... j) can form a palindromic substring,
     * dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
     * When we found a palindrome, check if it's the longest one. Time complexity O(n^2).
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];
        // 循环方式需要注意：求dp[i][j]时，需保证dp[i+1][j-1]已经被赋值过
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public String longestPalindrome2(String s) {

        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        String result = "";

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (j - i + 1 > result.length())) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }


    private int lo, maxLen;
    public String longestPalindrome_voted(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        _5LongestPalindromicSubstring obj = new _5LongestPalindromicSubstring();
        String str = obj.longestPalindrome2("abcdcb");
        System.out.println(str);
    }
}
