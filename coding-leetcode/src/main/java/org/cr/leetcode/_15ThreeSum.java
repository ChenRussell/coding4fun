package org.cr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * <p>
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
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                tempList.add(nums[i]);
                permutate(res, tempList, target - nums[i], nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
//        if (nums.length < 3) return res;
//        int temp = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { // 这个条件很重要，可以不用每次都contains判断是否存在，时间可达标，否则Time Limit Exceeded
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int fuck = nums[i] + nums[low] + nums[high];
                if (fuck == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[low], nums[high]);
                    // 优化时间复杂度
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;

                    //if (!res.contains(list)) // 与上述的条件对应，有上面的条件，这些就不需要判断
                        res.add(list);
                } else if (fuck < 0) low++;
                else high--;
            }
        }}
        return res;
    }

    public static void main(String[] args) {
        _15ThreeSum threeSum = new _15ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
