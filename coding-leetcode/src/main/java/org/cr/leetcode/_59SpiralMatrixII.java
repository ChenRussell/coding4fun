package org.cr.leetcode;

import java.util.ArrayList;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/20
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 */
public class _59SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0,  down = n - 1;
        int left = 0, right = n - 1;
        int val = 1;
        while (left <= right && up <= down) {
            for (int j = left; j <= right; j++)
                matrix[up][j] = val++;
            up++;
            for (int i = up; i <= down; i++)
                matrix[i][right]= val++;
            right--;
            if (up <= down) {
                for (int j = right; j >= left; j--)
                    matrix[down][j] = val++;
            }
            down--;
            if (left <= right) {
                for (int i = down; i >= up; i--)
                    matrix[i][left] = val++;
            }
            left++;
            //left++; right--; up++; down--;
        }
        return matrix;
    }
}
