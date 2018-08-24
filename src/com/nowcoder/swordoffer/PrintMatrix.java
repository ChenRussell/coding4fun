package com.nowcoder.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 18-3-26
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

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
        PrintMatrix obj = new PrintMatrix();
        ArrayList<Integer> list = obj.printMatrix(arr2);
        System.out.println(list);
    }
}
