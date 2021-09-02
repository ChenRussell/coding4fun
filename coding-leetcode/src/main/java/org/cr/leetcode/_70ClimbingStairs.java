package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/01
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class _70ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        int res = 0, f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

    public int climbStairs2(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs2(n - 2);
    }

    public static void main(String[] args) {
        _70ClimbingStairs obj = new _70ClimbingStairs();
        System.out.println(obj.climbStairs2(4));
    }
}
