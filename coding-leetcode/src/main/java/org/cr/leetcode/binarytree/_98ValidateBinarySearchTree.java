package org.cr.leetcode.binarytree;

import java.util.Stack;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/22
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class _98ValidateBinarySearchTree {

    /**
     * 思路有问题，不能只比较局部的子树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.right != null &&(root.val <= root.left.val || root.val >= root.right.val)) {
            return false;
        } else if (root.left != null && root.right==null && root.val <= root.left.val) {
            return false;
        } else if (root.right != null && root.left==null && root.val >= root.right.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST_voted(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }

    public boolean isValidBST_iterative(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
