package org.cr.leetcode.binarytree;

import java.util.*;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/22
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [2,1]
 *
 *
 * Constraints:
 *
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _145BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root, pLastVisit = null;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }

        while (!stack.isEmpty()) {
            p = stack.pop();

            if (p.right == null || p.right == pLastVisit) {
                res.add(p.val);
                pLastVisit = p;
            } else {
                stack.push(p);
                p = p.right;
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal_voted(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal_voted(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal_voted(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }
}
