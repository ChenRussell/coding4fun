package org.cr.leetcode.binarytree;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/26
 *
 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class _437PathSumIII {

    /**
     * Typical recursive DFS.
     * Space: O(n) due to recursion.
     * Time: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return pathSumFrom(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int pathSumFrom(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return (root.val == targetSum ? 1 : 0)
                + pathSumFrom(root.left, targetSum - root.val)
                + pathSumFrom(root.right, targetSum - root.val);
    }
}
