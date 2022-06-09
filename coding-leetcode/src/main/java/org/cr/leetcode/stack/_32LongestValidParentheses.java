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
     * ˼·��ʹ��ջ���Ϸ���������ϵ�������ʣ�µľ��ǲ��Ϸ������ŵ�idx��
     * ����ջ��������idx: 2, 5����ô���Ϸ���Χ����max([0,2), (2, 5), (5,s.length()) )
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

    // ��ͬ˼·�� һ��ѭ�����
    public int longestValidParentheses2(String s) {
        int res = 0;
        s += "x";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                if (stack.isEmpty()) { // ջΪ�գ�˵��iǰ��Ĳ��ֶ���valid
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
