package org.cr.leetcode.binarytree;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/22
 */
public class _104MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
