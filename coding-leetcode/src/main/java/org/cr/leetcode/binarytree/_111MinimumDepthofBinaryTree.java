package org.cr.leetcode.binarytree;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/22
 * <p>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 * <p>
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
public class _111MinimumDepthofBinaryTree {

    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepth(root, 1);
        return minDepth;
    }

    private void minDepth(TreeNode root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
        }

        minDepth(root.left, depth + 1);
        minDepth(root.right, depth + 1);
    }

    public int minDepth_voted(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    public static void main(String[] args) {
        _111MinimumDepthofBinaryTree obj = new _111MinimumDepthofBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.right = treeNode1;
        treeNode1.right = treeNode2;
        treeNode.left = treeNode4;
        System.out.println(obj.minDepth(treeNode));
    }
}
