package com.nowcoder.leetcode.dfs;

/**
 * Created by ChenRui on 18-4-7
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is
 * the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class _111MinimumDepthofBinaryTree {

    private int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        int depth = 1;
        if (root == null) return 0;
        getDepth(root, depth);
        return min;
    }

    private void getDepth(TreeNode root, int depth) {
        if (root != null) {
            if (root.left==null && root.right==null && depth < min) min = depth;

            getDepth(root.left, depth+1);
            getDepth(root.right, depth+1);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.right.right = new TreeNode(4);
        node.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(5);

        int res = new _111MinimumDepthofBinaryTree().minDepth(node);
        System.out.println(res);
    }
}
