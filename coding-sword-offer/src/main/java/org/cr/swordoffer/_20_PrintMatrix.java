package org.cr.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 18-3-26
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬
 * ����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _20_PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();

        int row = 0;
        int column = matrix[row].length-1;
        while (row < matrix.length && column >=0) {

            for (int i = matrix[row].length-1-column; i <= column; i++) {
                arr.add(matrix[row][i]);
            }

            for (int i = row+1; i < matrix.length-row; i++) {
                arr.add(matrix[i][column]);
            }

            for (int i = column-1; i >= matrix[row].length-1-column && (matrix.length-1-row>row); i--) {
                arr.add(matrix[matrix.length-1-row][i]);
            }

            for (int i = matrix.length-1-row-1; i > row && (matrix[row].length-1-column<column); i--) {
                arr.add(matrix[i][matrix[row].length-1-column]);
            }

            ++row;
            --column;
            if (row == matrix.length-1) break;
            if (column == 0) break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr ={
                {1,2,3,4},
                {5,6,7,8}
                };
        int arr2[][]={{1,2},{2,3},{3,4},{4,5}};
        _20_PrintMatrix obj = new _20_PrintMatrix();
        ArrayList<Integer> list = obj.printMatrix(arr2);
        System.out.println(list);
    }
}
