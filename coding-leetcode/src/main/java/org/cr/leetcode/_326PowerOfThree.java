package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/17
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 27
 * Output: true
 * Example 2:
 *
 * Input: n = 0
 * Output: false
 * Example 3:
 *
 * Input: n = 9
 * Output: true
 *
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 *
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class _326PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if(n > 1)
            while(n % 3 == 0) n /= 3;
        return n == 1;
    }

    /**
     * We can use this method to judge power of 2, 3, 5, 7, 11, ...
     * since they are prime numbers. But we can't do this to 4, because 4 = 2 * 2 and 4^n % 2^m == 0.
     */
    public boolean isPowerOfThree_voted(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }
}
