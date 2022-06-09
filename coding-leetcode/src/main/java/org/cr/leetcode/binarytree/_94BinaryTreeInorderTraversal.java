package org.cr.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/22
 *
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
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
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _94BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

//            if (!stack.isEmpty()) { // 此处的判断条件是多余的
                p = stack.pop();
                res.add(p.val);
                p = p.right;
//            }
        }
        return res;
    }

    public static void main(String[] args) {
        _94BinaryTreeInorderTraversal obj = new _94BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        root.left = treeNode;
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        System.out.println(obj.inorderTraversal(root));
    }
}
