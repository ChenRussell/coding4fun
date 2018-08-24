package com.nowcoder.leetcode.backpack;

import java.util.Arrays;

/**
 * Created by ChenRui on 18-4-6
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class _322CoinChange {

    /**
     * 题目分析：因为个数是无穷的，所以就是一个完全背包计数问题，
     * dp[i]表示合到i所需要的最少个数，dp初始化为无穷大，dp[0] = 0
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // dp[j]表示amount为j时，所需要的最少的数
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {   // 可重复选择!!!!!!!!!!, 如果不可重复选择就右到左循环
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]]+1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE/2) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int coins[] = {2};
        int amount = 4;
        int res = new _322CoinChange().coinChange(coins, amount);
        System.out.println(res);
    }
}
