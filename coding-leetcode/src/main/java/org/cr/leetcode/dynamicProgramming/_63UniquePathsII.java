package org.cr.leetcode.dynamicProgramming;

/**
 * Created by ChenRui on 2018/9/18.
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * <p>
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 *
 * Example 1:

 Input:
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 Output: 2
 Explanation:
 There is one obstacle in the middle of the 3x3 grid above.
 There are two ways to reach the bottom-right corner:
 1. Right -> Right -> Down -> Down
 2. Down -> Down -> Right -> Right
 */
public class _63UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length, col = obstacleGrid[0].length;

        int dp[][] = new int[row][col];
        if (obstacleGrid[0][0] == 1) return 0;

        dp[0][0] = 1;   // ≥ı º÷µ

        // initialize the first column
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i-1][0];  //£°£°£°£°
            } else {
                dp[i][0] = 0;
            }
        }

        // initialize the first row
        for (int j = 1; j < col; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j-1];
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        _63UniquePathsII uniquePathsII = new _63UniquePathsII();
        int res = uniquePathsII.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(res);
    }
}
