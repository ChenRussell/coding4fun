package com.nowcoder.leetcode.backpack;

/**
 * Created by ChenRui on 18-4-6
 *
 * 背包问题二（最大放入价值）
 *
 * 题目描述：
 *
 *  Given n items with size Ai and value Vi, and a backpack with size m.
 *  What's the maximum value can you put into the backpack?
 * 样例输入
 *
 *     10,[2,3,5,7],[1,5,2,4]
 * 样例输出
 *
 *     9
 */
public class BackPackII {

    public int backpack(int weight[], int value[], int m) {

        int dp[][] = new int[weight.length][m + 1];
        // 初始化dp数组, j表示背包的大小
        for (int j = 0; j < m + 1; j++) {
            if (j>=weight[0]) dp[0][j] = value[0]; // dp存储的是value，不是背包的大小i
        }

        for (int j = 1; j < m + 1; j++) {
            for (int i = 1; i < weight.length; i++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], value[i]+dp[i-1][j-weight[i]]);
                }
            }
        }

        for (int[] aDp : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(aDp[j] + "\t");
            }
            System.out.println();
        }
        return dp[weight.length - 1][m];
    }

    public int backpack_1d(int weight[], int value[], int m) {

        int dp[] = new int[m + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= weight[i]) dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }

            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }
        return dp[m];
    }

    public static void main(String[] args) {
        int nums[] = {2,3,5,7};
        int value[] = {1,5,2,4};
        int res = new BackPackII().backpack_1d(nums, value, 10);
        System.out.println("res: " + res);
    }
}
