package org.cr.leetcode.binarysearch;

/**
 * Created by ChenRui on 2018/9/16.
 * <p>
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class _35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while(low <= high) {
            mid = (low + high) >> 1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid + 1;
        }
        return low;
    }
}
