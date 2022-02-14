package org.cr.leetcode.dynamicProgramming;

/**
 * Created by ChenRui on 2018/9/18.
 * <p>
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class _64MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int row = grid.length, col = grid[0].length;
        int dp[][] = new int[row][col];

        // initialize the first row
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // initialize the first column
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        // 局部最有到全局最优
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[row - 1][col - 1];
    }

    public int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for(int i = 1; i <grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        _64MinimumPathSum minimumPathSum = new _64MinimumPathSum();
        int res = minimumPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(res);
    }
}
