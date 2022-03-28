package org.cr.leetcode.dynamicProgramming;

/**
 * Created by ChenRui on 18-3-5
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class _32LongestValidParentheses {
    /**
     * dp[i]  ��ʾ���±�i�ַ���β�����Ч���ŵĳ���
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2; // ���i-(dp[i-1]+2)>=0,����Ҫ����dp[i-dp[i-1]-2]
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        _32LongestValidParentheses obj = new _32LongestValidParentheses();
        int result = obj.longestValidParentheses("()()(())");   //8
        System.out.println(result);
    }
}
