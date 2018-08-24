package com.nowcoder.leetcode.dfs;

/**
 * Created by ChenRui on 18-4-7
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */
public class _110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return balance(root)!=-1;
    }

    // 求二叉树深度的函数改编过来的
    // check left and right node in every recursion to avoid further useless search
    private int balance(TreeNode root) {

        if (root == null) return 0;

        int lh = balance(root.left);
        if (lh == -1) return -1;

        int rh = balance(root.right);
        if (rh == -1) return -1;

        if (lh - rh < -1 || lh - rh > 1) {
            return -1;
        }

        return Math.max(lh, rh)+1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(5);
//        node.left.left.right = new TreeNode(5);

        boolean res = new _110BalancedBinaryTree().isBalanced(node);
        System.out.println(res);
    }
}
