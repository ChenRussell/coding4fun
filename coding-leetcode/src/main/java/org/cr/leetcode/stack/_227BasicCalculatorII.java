package org.cr.leetcode.stack;

import java.util.Stack;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/09
 *
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 */
public class _227BasicCalculatorII {

    // 思路：加法和减法的数值往栈里放，最终都转化为加法；乘法和除法直接计算
    public int calculate(String s) {
        int res = 0, num = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+'; // 记录num前面的符号
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10 * num + s.charAt(i) - '0';
            }
            // 当i遍历到最后一个字符时，需要进行计算
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        for (Integer ele : stack) {
            res += ele;
        }
        return res;
    }
}
