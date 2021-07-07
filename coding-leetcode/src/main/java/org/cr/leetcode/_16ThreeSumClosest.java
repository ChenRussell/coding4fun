package org.cr.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _16ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        if (nums.length < 3) return 0;
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int low = i+1, high = nums.length-1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target){
                    result = target;
                    break;
                }
                else if (sum < target) low++;
                else high--;
                if (Math.abs(sum-target) < Math.abs(result-target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _16ThreeSumClosest threeSumClosest = new _16ThreeSumClosest();
        int res = threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(res);
    }
}
