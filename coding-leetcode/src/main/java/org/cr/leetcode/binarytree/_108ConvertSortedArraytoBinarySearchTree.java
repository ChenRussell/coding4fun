package org.cr.leetcode.binarytree;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/27
 *
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees
 * of every node never differs by more than one.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 */
public class _108ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    public TreeNode constructBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int middle = (start + end) >> 1;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = constructBST(nums, start, middle - 1);
        node.right = constructBST(nums, middle + 1, end);
        return node;
    }
}
