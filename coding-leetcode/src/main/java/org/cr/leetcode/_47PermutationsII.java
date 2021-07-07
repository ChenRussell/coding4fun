package org.cr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class _47PermutationsII {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int start = 0;
        permutation(res, tempList, nums, start);

        return res;
    }

    private void permutation(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        if (tempList.size() == nums.length) {
            if (!res.contains(tempList))
            res.add(new ArrayList<>(tempList));
        }else {

            for (int i = start; i < nums.length; i++) {
//            if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                permutation(res, tempList, nums, start + 1);
//            tempList.remove(nums[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _47PermutationsII permutations = new _47PermutationsII();
        List<List<Integer>> permute = permutations.permute(new int[]{1, 1, 2});
        System.out.println(permute);
    }
}
