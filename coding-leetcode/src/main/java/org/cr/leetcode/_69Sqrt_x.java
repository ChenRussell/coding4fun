package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/20
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 */
public class _69Sqrt_x {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        long i = x;
        while(i > x / i) {
            i = (i + x / i) / 2;
        }
        return (int)i;
    }

    /**
     * Look for the critical point: i * i <= x && (i+1)(i+1) > x
     * A little trick is using i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x <= 1) return x;
        int start = 0, end = x;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
