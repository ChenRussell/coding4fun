package com.nowcoder.leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenRui on 18-4-2
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
