package org.cr.leetcode.binarytree;


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

public class _112PathSum {

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(targetSum - root.val == 0 && root.left == null && root.right == null) return true;
        return hasPathSum2(root.left, targetSum-root.val) || hasPathSum2(root.right,targetSum-root.val);
    }

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

        boolean res = new _112PathSum().hasPathSum(node, 12);
        System.out.println(res);
    }
}
