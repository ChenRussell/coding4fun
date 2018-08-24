package com.nowcoder.leetcode;

/**
 * Created by ChenRui on 2018/3/28
 * <p>
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class _27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i=0,j=nums.length-1;
        while (i < j) {
            // 找到第一个等于val的元素
            while (i < j && nums[i]!=val) {
                i++;
            }
            // 找到第一个不等于val的元素
            while (i < j && nums[j] == val) {
                j--;
            }
            if (i < j) {

                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = temp;
            }
        }
        int count=0;
        for (int p = 0; p < nums.length; p++) {
            if (nums[j] != val) {
                count++;
            }
        }
        return count;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,2,3};
        _27RemoveElement obj = new _27RemoveElement();
        int res = obj.removeElement2(arr, 3);
        System.out.println(res);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
