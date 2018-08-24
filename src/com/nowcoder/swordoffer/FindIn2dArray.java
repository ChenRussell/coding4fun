package com.nowcoder.swordoffer;

/**
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindIn2dArray {
    private boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) return false;
        int row = 0, col = array[0].length - 1;
        while (row < array.length && col >= 0) {    // 单重循环，时间复杂度O(n)
            if (target < array[row][col]) col--;
            else if (target > array[row][col]) row++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        boolean b = new FindIn2dArray().find(1, array);
        System.out.println(b);
    }
}
