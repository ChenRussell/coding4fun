package org.cr.leetcode.binarytree;

import java.util.Stack;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/22
 *
 * 230. Kth Smallest Element in a BST
 * Medium
 *
 * 4542
 *
 * 96
 *
 * Add to List
 *
 * Share
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 */
public class _230KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            if (--k == 0) return p.val;
            p = p.right;
        }
        return 0;
    }
}
