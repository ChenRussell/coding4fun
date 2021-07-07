package org.cr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _46Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int start = 0;
        permutation(res, tempList, nums, start);

        return res;
    }

    private void permutation(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            permutation(res, tempList, nums, i+1);
//            tempList.remove(nums[i]);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        _46Permutations permutations = new _46Permutations();
        List<List<Integer>> permute = permutations.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
