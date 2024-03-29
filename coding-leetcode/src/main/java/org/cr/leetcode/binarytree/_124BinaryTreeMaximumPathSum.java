package org.cr.leetcode.binarytree;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/24
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 */
public class _124BinaryTreeMaximumPathSum {

    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findPath(root);
        return maxValue;
    }

    public int findPath(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(findPath(node.left), 0);
        int right = Math.max(findPath(node.right), 0);
        // maxValue is the value which recording whether this current root is the final root,
        // so we use left + right + node.val. But to the upper layer(after return statement),
        // we cannot choose both left and right brunches, so we need to select the larger one,
        // so we use max(left, right) + node.val to prune the lower brunch.
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
