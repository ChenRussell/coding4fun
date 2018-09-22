package com.nowcoder.leetcode.dynamicProgramming;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security
 * system connected and it will automatically contact the police if two adjacent houses were broken into
 * on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class _213HouseRooberII {

    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        // 去掉首尾相连的情况
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end) {
        int res = 0;
        int dp[] = new int[nums.length];
        for (int i = start; i < end; i++) {

            if (i == start) {
                dp[i] = nums[i];
                res = dp[i];
            } else if (i == start+1) {
                dp[i] = nums[i];
                res = Math.max(dp[i - 1], dp[i]);
            } else if (i == start+2) {
                dp[i] = nums[i] + nums[i - 2];
                res = Math.max(res, dp[i]);
            } else if (i > start+2){
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
                res = Math.max(dp[i], res);
            }
        }

        return res;
    }

    private int rob2(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        _213HouseRooberII houseRooberII = new _213HouseRooberII();
        int res = houseRooberII.rob(new int[]{2,1,1,2});
        System.out.println(res);
    }
}
