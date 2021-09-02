package org.cr.leetcode;

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

    public boolean isValid2(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '('|| arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            }else if(arr[i] == ')' || arr[i] == ']' || arr[i] == '}') {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(!(arr[i] == ')' && top == '(' || arr[i] == ']' && top == '[' || arr[i] == '}' && top == '{')) return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public boolean isValid_voted(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({})";
        boolean res = new _20ValidParentheses().isValid(str);
        System.out.println(res);
    }
}
