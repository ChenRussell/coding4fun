package org.cr.leetcode.dfs;

import org.cr.leetcode.dfs._79WordSearch;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/01/25
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class _200NumberOfIslands {

    /**
     * 与{@link _79WordSearch}思路类似
     */
    public int numIslands(char[][] grid) {
        int count = 0, row = grid.length - 1, col = grid[0].length - 1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (grid[i][j] == '1') {
                    dfsMark(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsMark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfsMark(grid, i + 1, j);
        dfsMark(grid, i - 1, j);
        dfsMark(grid, i, j + 1);
        dfsMark(grid, i, j - 1);
    }
}
