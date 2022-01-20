package org.cr.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 18-3-26
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _20_PrintMatrix {

    /**
     * rubbish code!!!
     *
     * Wrong Answer
     * Details
     * Input
     * [[23,18,20,26,25],[24,22,3,4,4],[15,22,2,24,29],[18,15,23,28,28]]
     * Output
     * [23,18,20,26,25,4,29,28,28,23,15,18,15,24,22,3,4,24,2,22,2]
     * Expected
     * [23,18,20,26,25,4,29,28,28,23,15,18,15,24,22,3,4,24,2,22]
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();

        int row = 0;
        int column = matrix[row].length - 1;
        while (row < matrix.length && column >= 0) {

            for (int i = matrix[row].length - 1 - column; i <= column; i++) {
                arr.add(matrix[row][i]);
            }

            for (int i = row + 1; i < matrix.length - row; i++) {
                arr.add(matrix[i][column]);
            }

            for (int i = column - 1; i >= matrix[row].length - 1 - column && (matrix.length - 1 - row > row); i--) {
                arr.add(matrix[matrix.length - 1 - row][i]);
            }

            for (int i = matrix.length - 1 - row - 1; i > row && (matrix[row].length - 1 - column < column); i--) {
                arr.add(matrix[i][matrix[row].length - 1 - column]);
            }

            ++row;
            --column;
            if (row == matrix.length - 1) break;
            if (column == 0) break;
        }
        return arr;
    }

    public ArrayList<Integer> printMatrix2(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }

    public ArrayList<Integer> printMatrix3(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;
        while (res.size() < n * m) {
            for (int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[up][j]);

            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                res.add(matrix[i][right]);

            for (int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);

            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                res.add(matrix[i][left]);

            left++; right--; up++; down--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        int arr2[][] = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        _20_PrintMatrix obj = new _20_PrintMatrix();
        ArrayList<Integer> list = obj.printMatrix(arr2);
        System.out.println(list);
    }
}
