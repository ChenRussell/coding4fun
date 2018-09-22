package com.nowcoder.leetcode;

/**
 * Created by ChenRui on 2018/9/15.
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 */
public class _33SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int head = 0, tail = nums.length - 1;
        int minIndex = -1;
        while (nums[head] > nums[tail]) {
            int middle = (head + tail) / 2;
            if (head == tail - 1) {
                minIndex = tail;    // find the min element index
                break;
            }

            if (nums[middle] > nums[head]) {
                head = middle;
            }
            if (nums[middle] < nums[tail]) {
                tail = middle;
            }
        }
        System.out.println(minIndex);
        if (minIndex == -1) return divide(nums, 0, nums.length - 1, target);

        if (target <= nums[nums.length - 1]) {
            return divide(nums, minIndex, nums.length - 1, target);
        } else {
            return divide(nums, 0, minIndex - 1, target);
        }
    }

    int divide(int nums[], int left, int right, int target) {
        while (left <= right) {     // 二分查找判断条件是 <= !!!!!!!!!!!!!
            int mid = (left + right) /2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        _33SearchInRotatedSortedArray searchInRotatedSortedArray = new _33SearchInRotatedSortedArray();
//        int res = searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        int res = searchInRotatedSortedArray.search(new int[]{1}, 0);
        System.out.println(res);
    }
}
