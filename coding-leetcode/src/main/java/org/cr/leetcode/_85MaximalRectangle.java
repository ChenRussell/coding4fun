package org.cr.leetcode;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/24
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 * Example 3:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * rows == matrix.length
 * cols == matrix[i].length
 * 1 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */
public class _85MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int res = 0, rows = matrix.length, cols = matrix[0].length;
        int[] height = new int[cols];
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '1') {
                    height[i] += 1;
                } else {
                    height[i] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        return 0;
    }
}
