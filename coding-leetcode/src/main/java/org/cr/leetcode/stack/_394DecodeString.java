package org.cr.leetcode.stack;

import java.util.Stack;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/15
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed,
 * etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
public class _394DecodeString {

    public String decodeString(String s) {
        String res = "";
        Stack<String> stack1 = new Stack<>(); // '['Ç°µÄ×Ö·û´®ÈëÕ»
        Stack<Integer> stack2 = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                int repeatNum = 0;
                while (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    repeatNum = 10 * repeatNum + s.charAt(idx) - '0';
                    idx++;
                }
                stack2.push(repeatNum);
            } else if (s.charAt(idx) == '[') {
                stack1.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder tempStr = new StringBuilder(stack1.pop());
                int repeatNum = stack2.pop();
                for (int i = 0; i < repeatNum; i++) {
                    tempStr.append(res);
                }
                res = tempStr.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public String decodeString_voted(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _394DecodeString obj = new _394DecodeString();
        System.out.println(obj.decodeString("abc3[cd]xyz"));
    }
}
