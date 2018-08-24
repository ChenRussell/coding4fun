package com.nowcoder.leetcode.backpack;

/**
 * Created by ChenRui on 18-4-7
 *
 * 背包问题五（最大重量+所有可能结果+不同排列）
 *
 * 题目描述：
 *
 *  Given n items with size nums[i] which an integer array and all positive numbers.
 *  An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
 *  Each item may only be used once
 * 样例输入：
 *
 * [1,2,3,3,7],7
 * 样例输出：
 *
 * 2
 */
public class BackPackV {

    public int backpack(int weight[], int target) {
        // dp[j]表示背包大小为j时，装满背包的所有可能结果（不可重复使用）
        int dp[] = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < weight.length; i++) {
            for (int j = target; j > 0; j--) {
                if (j>=weight[i]) dp[j] += dp[j - weight[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int weight[] = {2, 2, 2, 3, 3, 3};
        int weight2[] = {1,2,3};
        int k = 5;
        int res = new BackPackV().backpack(weight2, 4);
        System.out.println(res);
    }
}
