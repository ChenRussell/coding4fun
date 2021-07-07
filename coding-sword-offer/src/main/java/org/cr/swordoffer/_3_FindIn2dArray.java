package org.cr.swordoffer;

/**
 * ��Ŀ����
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
 * ����������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class _3_FindIn2dArray {
    private boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) return false;
        int row = 0, col = array[0].length - 1;
        while (row < array.length && col >= 0) {    // ����ѭ����ʱ�临�Ӷ�O(n)
            if (target < array[row][col]) col--;
            else if (target > array[row][col]) row++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        boolean b = new _3_FindIn2dArray().find(1, array);
        System.out.println(b);
    }
}
