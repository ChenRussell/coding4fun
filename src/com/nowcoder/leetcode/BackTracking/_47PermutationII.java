package com.nowcoder.leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenRui on 18-4-3
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class _47PermutationII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  // 保证相同的元素是连着的
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(res, tempList, nums, used, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used, int start) {

        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {

                // 第二个条件是为了防止重复的元素，如： 1,2(1),2(2) 和 1,2(2),2(1), 只能算一个
                if (used[i] || i>1 && nums[i] == nums[i-1] && !used[i-1]) continue;  // 用一个used数组维护该位置的元素是否被访问
                tempList.add(nums[i]);
                used[i] = true;
                backTracking(res, tempList, nums, used, i + 1);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = new _47PermutationII().permuteUnique(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
