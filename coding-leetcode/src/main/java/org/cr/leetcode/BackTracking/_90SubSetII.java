package org.cr.leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenRui on 18-4-2
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class _90SubSetII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        backTracking(res, tempList, nums, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {

        // BOTH way to filter the duplicates
        if (!res.contains(tempList)) {
            res.add(new ArrayList<>(tempList));
        }

        for (int i = start; i < nums.length; i++) {

//            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backTracking(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2};
        List<List<Integer>> res = new _90SubSetII().subsetsWithDup(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
