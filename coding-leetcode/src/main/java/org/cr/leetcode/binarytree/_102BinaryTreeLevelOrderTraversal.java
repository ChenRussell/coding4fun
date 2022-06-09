package org.cr.leetcode.binarytree;

import java.util.*;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/22
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
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
 * -1000 <= Node.val <= 1000
 */
public class _102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            ArrayList<Integer> subList = new ArrayList<>();
            // 同一层的一起拿出来，每次while循环对应一层
            for (int i = 0; i < levelNum; i++) {
                TreeNode parent = queue.poll();
                if (parent.left != null) {
                    queue.offer(parent.left);
                }
                if (parent.right != null) {
                    queue.offer(parent.right);
                }
                subList.add(parent.val);
            }
            res.add(subList);
        }
        return res;
    }

    public static void main(String[] args) {
            _102BinaryTreeLevelOrderTraversal obj = new _102BinaryTreeLevelOrderTraversal();
            TreeNode root = new TreeNode(3);
            TreeNode treeNode = new TreeNode(9);
            TreeNode treeNode4 = new TreeNode(8);
            TreeNode treeNode1 = new TreeNode(20);
            TreeNode treeNode2 = new TreeNode(15);
            TreeNode treeNode3 = new TreeNode(7);
            root.left = treeNode;
            root.right = treeNode1;
            treeNode1.left = treeNode2;
            treeNode1.right = treeNode3;
            treeNode.left = treeNode4;
            System.out.println(obj.levelOrder(root));
    }
}
