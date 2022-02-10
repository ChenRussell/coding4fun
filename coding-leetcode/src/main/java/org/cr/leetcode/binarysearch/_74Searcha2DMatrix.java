package org.cr.leetcode.binarysearch;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/07
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class _74Searcha2DMatrix {

    /**
     * treat matrix as 1D sorted array, use binary search
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int head = 0, tail = row * col - 1;
        while (head <= tail) {
            int mid = (head + tail) >> 1;
            if (matrix[mid / col][mid % col] == target) return true;
            else if (matrix[mid / col][mid % col] < target) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        return false;
    }
}
