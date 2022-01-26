package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/02
 * <p>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class _215KthLargestElementinanArray {

    public int findKthLargest_20220126(int[] nums, int k) {
        int low = 0, high = nums.length-1;
        k = nums.length - k;
        int index = -1;
        while(index != k) {
            index = partition(nums, low, high);
            if(index < k) low = index+1;
            else if(index > k) high = index-1;
        }
        return nums[index];
    }

    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        k = nums.length - k;
        int index = partition(nums, low, high);
        while (index != k) {
            if (index < k) {
                low = index + 1;
                index = partition(nums, low, high);
            } else {
                high = index - 1;
                index = partition(nums, low, high);
            }
        }
        return nums[index];
    }

    public int findKthLargest(int[] nums, int k, int start, int end) {
        if (start < end) {
            int index = partition(nums, start, end);
            if (index == k - 1) return nums[index];
            else if (index < k - 1) {
                findKthLargest(nums, k, index + 1, end);
            } else {
                findKthLargest(nums, k, start, index - 1);
            }
        }
        return Integer.MIN_VALUE;
    }

    public int partition(int[] nums, int low, int high) {
        int target = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= target) high--;
            if (low < high) nums[low++] = nums[high];
            while (low < high && nums[low] <= target) low++;
            if (low < high) nums[high--] = nums[low];
        }
        nums[low] = target;
        return low;
    }
}
