package org.cr.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ChenRui on 2018/9/28.
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes
 * p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 * according to the LCA definition.
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */

public class _236LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == null || q == null) {
            return null;
        }

        if (p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else return left;
    }

    /**
     * 找到两条路径，返回最后一个相等的元素
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        List<List<TreeNode>> path = new ArrayList<>();
        findPath(root, p, q, stack1, path);
        List<TreeNode> path1 = path.get(0);
        List<TreeNode> path2 = path.get(1);
        System.out.println(path1);
        System.out.println(path2);
        int idx = 0;
        while (idx < path1.size() && idx < path2.size()) {
            if (path1.get(idx).val == path2.get(idx).val) {
                idx++;
            } else {
                break;
            }
        }
        return idx == 0 ? null : path1.get(idx - 1);
    }

    private void findPath(TreeNode node, TreeNode p,TreeNode q, Stack<TreeNode> stack, List<List<TreeNode>> path) {
        if (node == null) return;
        stack.push(node);
        if (node == p || node == q) {
            path.add(new ArrayList<>(stack));
        }
        findPath(node.left, p, q, stack, path);
        findPath(node.right, p, q, stack, path);
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);

        _236LowestCommonAncestor lowestCommonAncestor = new _236LowestCommonAncestor();
        TreeNode treeNode = lowestCommonAncestor.lowestCommonAncestor2(node, node.right, node.left.left);
        System.out.println(treeNode.val);
    }
}
