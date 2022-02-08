package org.cr.leetcode.bits;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/08
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 *
 *
 * Constraints:
 *
 * -1000 <= a, b <= 1000
 */
public class _371SumOfTwoIntegers {

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a^b, (a&b)<<1);
    }
}
