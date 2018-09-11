package com.nowcoder.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 *
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;
        int start = 0;
        permutate(res, tempList, target, nums, start);
        return res;
    }

    private void permutate(List<List<Integer>> res, List<Integer> tempList, int target, int[] nums, int start) {
        if (tempList.size() == 3 && target == 0) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i ++) {
                if (i>start && nums[i] == nums[i-1]) continue;
                tempList.add(nums[i]);
                permutate(res, tempList, target - nums[i], nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _15ThreeSum threeSum = new _15ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
