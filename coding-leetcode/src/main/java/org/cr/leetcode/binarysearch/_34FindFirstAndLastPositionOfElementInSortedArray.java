package org.cr.leetcode.binarysearch;

/**
 * Created by ChenRui on 2018/9/16.
 * <p>
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class _34FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int head = -1, tail = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else  {
                if (mid > 0 && nums[mid] != nums[mid - 1] || mid==0){
                    head = mid;
                    break;
                } else right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else  {
                if (mid+1<nums.length && nums[mid]!=nums[mid+1] || mid == nums.length-1){
                    tail = mid;
                    break;
                } else left = mid + 1;
            }
        }

        return new int[]{head, tail};
    }

    public int[] searchRange2(int[] nums, int target) {
        return new int[]{findLeft(nums, target), findRight(nums,target)};
    }

    int findLeft(int[] nums,int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int middle = (low + high) >> 1;
            if(target < nums[middle]) {
                high = middle-1;
            } else if(target > nums[middle]) {
                low = middle+1;
            } else {
                if(middle == 0 || nums[middle] != nums[middle-1]){
                    return middle;
                } else {
                    high = middle-1;
                }
            }
        }
        return -1;
    }

    int findRight(int[] nums,int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int middle = (low + high) >> 1;
            if(target < nums[middle]) {
                high = middle-1;
            } else if(target > nums[middle]) {
                low = middle+1;
            } else {
                if(middle == nums.length-1 || nums[middle] != nums[middle+1]){
                    return middle;
                } else {
                    low = middle+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _34FindFirstAndLastPositionOfElementInSortedArray obj = new _34FindFirstAndLastPositionOfElementInSortedArray();
        int[] res = obj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(res[0]+" "+res[1]);
    }
}
