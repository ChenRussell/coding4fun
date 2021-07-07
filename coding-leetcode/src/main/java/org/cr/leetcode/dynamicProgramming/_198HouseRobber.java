package org.cr.leetcode.dynamicProgramming;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were
 * broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * <p>
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class _198HouseRobber {

    // bullshit
    public int rob(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0, j = 1; ; i += 2, j += 2) {
            if (i < nums.length) sum1 += nums[i];
            if (j < nums.length) sum2 += nums[j];
            if (i >= nums.length && j >= nums.length) break;
        }
        return Math.max(sum1, sum2);
    }

    public int rob2(int[] nums) {
        int res = 0;
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                dp[i] = nums[i];
                res = dp[i];
            } else if (i == 1) {
                dp[i] = nums[i];
                res = Math.max(dp[i - 1], dp[i]);
            } else if (i == 2) {
                dp[i] = nums[i] + nums[i - 2];
                res = Math.max(res, dp[i]);
            } else {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
                res = Math.max(dp[i], res);
            }
        }

        return res;
    }

    public int rob3(int[] nums) {
        int prevNo = 0;    // No: means we don't rob the current house
        int prevYes = 0;    // Yes: means we rob the current house
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);  // not rob current house, current max will depends on previous value: Math.max(prevNo, prevYes)
            prevYes = n + temp;    // rob current one, add current stashed money value
        }
        return Math.max(prevNo, prevYes);
    }

    public static void main(String[] args) {
        _198HouseRobber houseRobber = new _198HouseRobber();
        int res = houseRobber.rob3(new int[]{2, 1, 1, 2});
        System.out.println(res);
    }
}
