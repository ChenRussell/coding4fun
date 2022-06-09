package org.cr.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/11
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: [[1]]
 * Example 4:
 *
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 *
 *
 * Constraints:
 *
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class _48RotateImage {

    /**
     * 两步走：
     * 1. 交换对角元素
     * 2. reverse row（not reverse col，就不能交换matrix[i][j]和matrix[j][i]）
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] arr : matrix) {
            reverse(arr);
        }
    }

    public void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length-1-i] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new _48RotateImage().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> collect = Arrays.stream(matrix[i]).boxed().collect(Collectors.toList());
            System.out.println(collect);
        }
    }
}
