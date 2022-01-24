package org.cr.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenRui on 18-4-3
 * <p>
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class _40CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);    // ���������Ǻܹؼ���
        backTracking(res, tempList, candidates, target, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target == 0 /*&& !res.contains(tempList)*/) {   // ���������ʱ�临�Ӷ�̫��,no��������Ϊ����ط�
            res.add(new ArrayList<>(tempList));
        } else if (target>0){   // target<0��Ҫ���˵�������ʱ�临�Ӷȹ��ߣ�����������
            for (int i = start; i < candidates.length; i++) {
                if (i>start && candidates[i] == candidates[i-1]) continue;  // skip duplicates
                tempList.add(candidates[i]);
                backTracking(res, tempList, candidates, target-candidates[i], i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = new _40CombinationSumII().combinationSum2(nums, target);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
