package org.cr.leetcode.stack;

import java.util.Stack;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/21
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
public class _32LongestValidParentheses {

    /**
     * 思路：使用栈将合法的括号组合抵消掉，剩下的就是不合法的括号的idx，
     * 假设栈内有两个idx: 2, 5，那么最大合法范围就是max([0,2), (2, 5), (5,s.length()) )
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        int right = s.length(), left;
        if (stack.isEmpty()) {
            res = s.length();
        } else {
            while (!stack.isEmpty()) {
                left = stack.pop();
                res = Math.max(res, right - left - 1);
                right = left;
            }
            res = Math.max(res, right);
        }
        return res;
    }

    // 相同思路， 一次循环解决
    public int longestValidParentheses2(String s) {
        int res = 0;
        s += "x";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                if (stack.isEmpty()) { // 栈为空，说明i前面的部分都是valid
                    res = Math.max(res, i);
                } else {
                    res = Math.max(res, i - stack.peek() - 1);
                }
                stack.push(i);
            }
        }
        return stack.isEmpty() ? s.length() : res;
    }
}
