package org.cr.leetcode.backpack;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/22
 *
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class _494TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return ((target+sum) & 1) != 0 ? 0 : find(nums, (target+sum) >> 1);
    }

    public int find(int[] nums, int target) {
        if(target < 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1; // 初始值很关键
        for(int i = 0; i < nums.length; i++) {
            for(int j = target; j >= 0; j--) { // j>=0, 不能是j>0, 应对元素为0的情况
                if(j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    /**
     * The recursive solution is very slow, because its runtime is exponential
     *
     * The original problem statement is equivalent to:
     * Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target
     *
     * Let P be the positive subset and N be the negative subset
     * For example:
     * Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
     * Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
     *
     * Then let's see how this can be converted to a subset sum problem:
     *
     *                   sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * So the original problem has been converted to a subset sum problem as follows:
     * Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
     *
     * Note that the above formula has proved that target + sum(nums) must be even
     * We can use that fact to quickly identify inputs that do not have a solution (Thanks to @BrunoDeNadaiSarnaglia for the suggestion)
     * For detailed explanation on how to solve subset sum problem, you may refer to Partition Equal Subset Sum
     */
    public int findTargetSumWays_voted(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return (sum < s || (s + sum) % 2 > 0) ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }


    /**
     * Brute Force
     */
    int count = 0;
    public int findTargetSumWays_v3(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
}
