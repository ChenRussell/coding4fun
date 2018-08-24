package com.nowcoder.leetcode.backpack;

/**
 * Created by ChenRui on 18-4-6
 *
 * 背包问题一（最大放入重量）
 * 题目描述：
 *
 * Given n items with size Ai, an integer m denotes the size of a backpack.
 * How full you can fill this backpack?
 * 样例输入：
 *
 * [2,3,5,7],11
 * [2,3,5,7],12
 * 样例输出：
 *
 * 10
 * 12
 */
public class BackPackI {

    public int backpack(int A[], int m) {
        int dp[][] = new int[A.length][m+1];  // dp[i][j], 表示package为j时能放的最大的数

        // 初始化dp的第一行数据， j表示背包大小
        for (int j = 0; j <= m; j++) {
            if (j >= A[0]) dp[0][j] = A[0];
        }

        // 对背包大小遍历, 第二行开始
        for (int j = 1; j < m + 1; j++) {
            // 对A遍历
            for (int i = 1; i < A.length; i++) {
                if (j < A[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], A[i] + dp[i - 1][j - A[i]]);
                    // 比较dp[i-1][j]与dp[i-1][j-A[i]]+A[i]的大小
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[A.length - 1][m];
    }

    public int backpack_1d(int weight[], int m) {

        int dp[] = new int[m+1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = m; j > 0; j--) {   // 从右到左循环是不可重复选择，从左到右是可重复选择！！！！
                if (j>=weight[i]) dp[j] = Math.max(dp[j], dp[j - weight[i]]+weight[i]); // 与dp[j]相比
            }

            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k]+"\t");
            }
            System.out.println();
        }

        return dp[m];
    }

    public static void main(String[] args) {
        int nums[] = {2,3,5,7};
        int res = new BackPackI().backpack_1d(nums, 11);
        System.out.println("res: "+res);
    }
}
