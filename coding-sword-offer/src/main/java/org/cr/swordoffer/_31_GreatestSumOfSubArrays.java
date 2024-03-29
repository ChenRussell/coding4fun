package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/4/5
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class _31_GreatestSumOfSubArrays {

    public int findGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max = array[0];
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] < max) max = array[i];
//        }
        for (int i = 0; i < array.length; i++) {
            if (sum + array[i] > 0) {
                sum = sum + array[i];
                max = Math.max(max, sum);
            } else {
                sum = 0;
                max = Math.max(max, array[i]); // 重要！！
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {6,-3,-2,7,-15,1,2,2};
        int arr2[] = {-2, 1};
        int arr3[] = {1, -2};
        int arr4[] = {-1, 1, 2, 1};
        int res = new _31_GreatestSumOfSubArrays().findGreatestSumOfSubArray(arr4);
        System.out.println(res);
    }
}
