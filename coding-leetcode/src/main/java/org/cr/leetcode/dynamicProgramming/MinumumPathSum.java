package org.cr.leetcode.dynamicProgramming;

/**
 * Created by ChenRui on 18-3-5
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 �� 3 �� 1 �� 1 �� 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 */
public class MinumumPathSum {
    public int[][] minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) grid[i][j] += grid[i][j - 1];
                if (i != 0 && j == 0) grid[i][j] += grid[i - 1][j];
                if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        MinumumPathSum obj = new MinumumPathSum();
        /**
         * 1,3,1
         * 1,4,1
         * 4,2,1
         */
        int[][] grid = {{1,3,1},{1,4,1},{4,2,1}};
        int[][] sum = obj.minPathSum(grid);
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                System.out.print(sum[i][j]);
            }
            System.out.println();
        }
    }
}
