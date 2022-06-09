package org.cr.leetcode.dfs;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/21
 *
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 *
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 */
public class _329LongestIncreasingPathinaMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int max = 1, m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int[][] dirs = new int[][] {{1, 0},{-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, cache, dirs);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache, int[][] dirs) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[i][j] >= matrix[x][y]) continue;
            int len = 1 + dfs(matrix, x, y, cache, dirs);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

    /**
     * DFS + Memoization
     *
     * Traverse all points in matrix, use every point as starting point to do dfs traversal. DFS function returns max increasing
     * path after comparing four max return distance from four directions.
     *
     * @param cache: cache[i][j] represents the longest increasing path starts from point matrix[i][j]
     * @param prev: previous value used by DFS traversal, to compare whether current value is greater than previous value
     * */
    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath_voted(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int result = 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] cache = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curLen = dfs(matrix, cache, i, j, matrix[i][j]);
                result = Math.max(result, curLen);
            }
        }
        return result;
    }

    public int dfs(int[][] matrix, int[][] cache, int x, int y, int curPoint) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }

        // initialize max distance as 1 since the path includes starting point itself
        int max = 1;
        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];

            // if next point is out of bound or next point current point is greater than or equal to next point
            if (dx < 0 || dx > matrix.length - 1 || dy < 0 || dy > matrix[0].length - 1 || curPoint >= matrix[dx][dy]) {
                continue;
            }

            // if next point is a valid point, add curLen by 1 and continue DFS traversal
            int curLen = 1 + dfs(matrix, cache, dx, dy, matrix[dx][dy]);
            max = Math.max(max, curLen);
        }
        // update max increasing path value starting from current point in cache
        cache[x][y] = max;
        return max;
    }
}
