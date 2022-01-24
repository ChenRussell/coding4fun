package org.cr.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenRui on 18-4-2
 * <p>
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */
public class _39CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);    // ����     ���ݽ��Ҫ�� ��Ҫ��������
        backTracking(res, tempList, candidates, target, 0);
        return res;
    }

    /**
     * ���ݷ��� �����͵�����
     * @param res
     * @param tempList
     * @param candidates
     * @param target
     * @param start
     */
    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int start) {

        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<>(tempList)); // add new ArrayList<>(tempList)!!!!!!!, ����addһ�����ý�ȥ���������϶�Ϊ��
        }
        else {
            for (int i = start; i < candidates.length; i++) {

                tempList.add(candidates[i]);
                backTracking(res, tempList, candidates, target - candidates[i], i); // not i + 1 because we can reuse same elements!!!!!!
                tempList.remove(tempList.size() - 1);   // remove���¼ӽ�ȥ��
            }
        }
    }

    public static void main(String[] args) {
        int candidates[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        int candidates2[] = {3, 2, 6, 7};
        int target2 = 7;
        List<List<Integer>> res = new _39CombinationSum().combinationSum(candidates2, target2);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
