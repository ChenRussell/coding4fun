package org.cr.swordoffer;

import java.util.Arrays;

/**
 * @Description
 * @auther chenrui
 * @create 2020-12-27 23:11
 * <p>
 * ��ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ������������7��
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * ʾ��1
 * ����
 * 7
 * ����ֵ
 * 8
 */
public class _34_UglyNumber {

    public static void main(String[] args) {
        _34_UglyNumber obj = new _34_UglyNumber();
        System.out.println(Arrays.toString(obj.GetUglyNumber_Solution(15)));
    }

    public int[] GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return new int[]{0};
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int count = 1;
        while (count < index) {
            arr[count] = min(arr[p2] * 2, arr[p3] * 3, arr[p5] * 5);
            while (arr[p2] * 2 <= arr[count]) {
                ++p2;
            }
            while (arr[p3] * 3 <= arr[count]) {
                ++p3;
            }
            while (arr[p5] * 5 <= arr[count]) {
                ++p5;
            }
            ++count;
        }
        return arr;
    }

    private static int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }
}
