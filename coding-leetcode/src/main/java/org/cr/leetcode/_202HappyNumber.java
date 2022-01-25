package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/25
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
public class _202HappyNumber {

    public int digitSquare(int num) {
        int res = 0;
        while (num > 0) {
            int x = num % 10;
            res += x * x;
            num = num / 10;
        }
        return res;
    }

    /**
     * 思路与{@link org.cr.leetcode.linkedlist._141LinkedListCycle}类似，一定有一个环
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquare(slow);
            fast = digitSquare(fast);
            fast = digitSquare(fast);
            if(fast == 1) return true;
        } while (slow != fast);
        return false;
    }
}
