package org.cr.swordoffer;

import java.util.Arrays;

/**
 * @Description
 * @auther chenrui
 * @create 2020-12-27 23:11
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 示例1
 * 输入
 * 7
 * 返回值
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
