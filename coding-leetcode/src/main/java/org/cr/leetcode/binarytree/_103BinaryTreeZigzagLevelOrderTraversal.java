package org.cr.leetcode.binarytree;

import java.util.*;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/01/27
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class _103BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if (level % 2 == 1) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val); // 通过add(0, val)的方式实现反转，nice
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(subList);
        }
        return res;
    }
}
