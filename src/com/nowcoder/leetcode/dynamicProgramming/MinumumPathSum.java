package com.nowcoder.leetcode.dynamicProgramming;

/**
 * Created by ChenRui on 18-3-5
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
