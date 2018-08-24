package com.nowcoder.leetcode.dfs;


/**
 * Created by ChenRui on 18-4-7
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class _122PathSum {



    public boolean hasPathSum(TreeNode root, int sum) {

        if (root==null) return false;
        // root为叶子节点，且root.val == sum
        if (root.val == sum && root.left == null && root.right == null) return true;
        //else if (root.left==null && root.right == null) return false;

        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(5);

        boolean res = new _122PathSum().hasPathSum(node, 12);
        System.out.println(res);
    }
}
