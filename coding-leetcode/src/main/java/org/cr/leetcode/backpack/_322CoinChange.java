package org.cr.leetcode.backpack;

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
     * ��Ŀ��������Ϊ����������ģ����Ծ���һ����ȫ�����������⣬
     * dp[i]��ʾ�ϵ�i����Ҫ�����ٸ�����dp��ʼ��Ϊ�����dp[0] = 0
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // dp[j]��ʾamountΪjʱ������Ҫ�����ٵ���
        Arrays.fill(dp, Integer.MAX_VALUE/2); // Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {   // ���ظ�ѡ��!!!!!!!!!!, ��������ظ�ѡ����ҵ���ѭ��
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]]+1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE/2) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 11;
        int res = new _322CoinChange().coinChange(coins, amount);
        System.out.println(res);
    }
}
