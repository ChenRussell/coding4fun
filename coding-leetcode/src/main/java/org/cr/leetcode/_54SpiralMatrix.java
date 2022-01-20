package org.cr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/20
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class _54SpiralMatrix {

    // key point: res.size() < n * m
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while (res.size() < n * m) {
            for (int i = left; i <= right && res.size() < n * m; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i >= left && res.size() < n * m; i--) {
                res.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--) {
                res.add(matrix[i][left]);
            }
            left++; right--; up++; down--;
        }
        return res;
    }
}
