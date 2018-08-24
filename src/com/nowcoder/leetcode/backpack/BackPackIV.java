package com.nowcoder.leetcode.backpack;

/**
 * Created by ChenRui on 18-4-7
 *
 *背包问题四（最大重量+所有可能结果）
 *
 * 题目描述：
 *
 *  Given an integer array nums with all positive numbers and no duplicates,
 *  find the number of possible combinations that add up to a positive integer target.
 * 样例输入
 *
 * [1,2,4],4
 * 样例输出
 *
 * 6
 */
public class BackPackIV {

    public int backpack(int weight[], int target) {
        // dp[j]表示背包大小为j时，装满背包的所有可能结果数量
        int dp[] = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < weight.length; i++) {
            for (int j = 1; j < dp.length; j++) {   // 可重复使用元素
                if (j>=weight[i]) dp[j] += dp[j - weight[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int weight[] = {1,2,3};
        int target = 5;
        int res = new BackPackIV().backpack(weight, target);
        System.out.println(res);
    }
}
