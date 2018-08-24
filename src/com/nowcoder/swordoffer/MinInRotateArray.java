package com.nowcoder.swordoffer;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/**
 * 该题目考察的是二分查找的应用
 */
public class MinInRotateArray {
    /**
     * 该方法稍微优化，时间复杂度还是O(n)
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i + 1]) return array[i + 1];
        }
        return array[0];
    }

    /**
     * 应用二分查找，时间复杂度为O(log(n))
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int[] array) {
        int low = 0, high = array.length - 1;
        int middle = (low + high) / 2;
//        int middle = 0;
        if (array[low] == array[middle] && array[middle] == array[high])
            return minNumberInRotateArray(array);   // 此种情况只能用顺序查找，不能使用该方法
        middle = 0;
        while (array[low] >= array[high]) {      // 确保是旋转数组
            if (low + 1 == high) {
                middle = high;
                break;
            }
            if (array[low] <= array[middle]) low = middle;
            if(array[high] > array[middle]) high = middle;
            middle = (low + high) / 2;
        }
        return array[middle];
    }



    public static void main(String[] args) {
//        int[] array = {3, 4, 5, 1, 2};
        int[] array = {3, 4, 5, 6, 7};
        int i = new MinInRotateArray().minNumberInRotateArray2(array);
        System.out.println(i);
    }
}
