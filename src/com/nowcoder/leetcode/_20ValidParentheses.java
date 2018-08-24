package com.nowcoder.leetcode;

import java.util.Stack;

/**
 * Created by ChenRui on 18-4-6
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but
 * "(]" and "([)]" are not.
 */
public class _20ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            }

            if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
                if (!stack.empty()) {
                    Character peek = stack.peek();
                    if (peek == '('&&chars[i]==')' || peek=='['&&chars[i]==']' || peek=='{'&&chars[i]=='}') {
                        stack.pop();
                    }
                    else return false;
                }
                else return false;
            }
        }
        if (stack.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        String str = "({})";
        boolean res = new _20ValidParentheses().isValid(str);
        System.out.println(res);
    }
}
