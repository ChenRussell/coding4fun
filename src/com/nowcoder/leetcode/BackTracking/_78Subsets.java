package com.nowcoder.leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenRui on 18-4-2
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class _78Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        backTracking(res, tempList, nums, 0);
        return res;
    }

    /**
     * 使用回溯法解决求数组子集的问题
     * @param res
     * @param tempList
     * @param nums
     * @param start
     */
    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {

//        if (start >= nums.length) return;   // 递归边界

        res.add(new ArrayList<>(tempList)); // 啥时候add

        for (int i = start; i < nums.length; i++) {

            tempList.add(nums[i]);
            backTracking(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 1};
        List<List<Integer>> res = new _78Subsets().subsets(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
