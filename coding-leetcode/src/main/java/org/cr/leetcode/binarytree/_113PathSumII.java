package org.cr.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ChenRui on 18-4-7
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class _113PathSumII {

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        pathSum2(root, targetSum, res, stack);
        return res;
    }

    public void pathSum2(TreeNode root, int targetSum, List<List<Integer>> res, Stack<Integer> stack) {
        if (root == null) return;
        stack.push(root.val);
        if(targetSum == root.val && root.left == null && root.right == null) {
            List<Integer> tmpList = new ArrayList<>(stack);
//            tmpList.add(root.val);
            res.add(tmpList);
//            return;
        }
        pathSum2(root.left, targetSum-root.val, res, stack);
        pathSum2(root.right, targetSum-root.val, res, stack);
        stack.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
//        stack.push(root.val);
        findPath(root, sum, res, stack);
        return res;
    }

    private void findPath(TreeNode root, int sum, List<List<Integer>> res, Stack<Integer> stack) {
        if (root != null) {

            stack.push(root.val);

            if (root.val == sum && root.left == null && root.right == null) {
//                stack.push(root.val);
                res.add(new ArrayList<>(stack));
            }

            findPath(root.left, sum - root.val, res, stack);
            findPath(root.right, sum - root.val, res, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(1);
//        node.left.left = new TreeNode(5);
//        node.left.left.right = new TreeNode(5);
        List<List<Integer>> res = new _113PathSumII().pathSum(node, 5);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
