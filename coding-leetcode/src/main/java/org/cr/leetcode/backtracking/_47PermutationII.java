package org.cr.leetcode.backtracking;

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
        Arrays.sort(nums);  // ��֤��ͬ��Ԫ�������ŵ�
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

                // �ڶ���������Ϊ�˷�ֹ�ظ���Ԫ�أ��磺 1,2(1),2(2) �� 1,2(2),2(1), ֻ����һ��,used[i-1]ȡ��ȡ�������ԣ��൱��ѡ��������һ�����з�ʽ
                if (used[i] || i>1 && nums[i] == nums[i-1] && !used[i-1]) continue;  // ��һ��used����ά����λ�õ�Ԫ���Ƿ񱻷���
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
