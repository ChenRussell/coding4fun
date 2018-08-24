package com.nowcoder.leetcode;

/**
 * Created by ChenRui on 18-4-6
 * Given a sorted array, remove the duplicates in-place such that each element appear
 * only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the
 * input array in-place with O(1) extra memory.
 *
 * Example:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2
 * respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class _26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,2,3,3,4,4,5,6};
        int res = new _26RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        System.out.println(res);
    }
}
