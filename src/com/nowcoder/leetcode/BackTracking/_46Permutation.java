package com.nowcoder.leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenRui on 18-4-2
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _46Permutation {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        backTracking(res, tempList, nums, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums, int start) {

        if (tempList.size() == nums.length) {

            res.add(new ArrayList<>(tempList));
        }
//        res.add(new ArrayList<>(tempList));
        else {  // 优化时间复杂度

            for (int i = 0; i < nums.length; i++) {

                if (tempList.contains(nums[i])) continue;   // 重复的就跳出，执行下一次循环
                tempList.add(nums[i]);
                backTracking(res, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,2};
        List<List<Integer>> res = new _46Permutation().permute(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
