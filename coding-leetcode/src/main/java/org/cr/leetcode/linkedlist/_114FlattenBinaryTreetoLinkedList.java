package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/15
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * Example 3:
 * <p>
 * Input: root = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class _114FlattenBinaryTreetoLinkedList {

    TreeNode preNode = null;

    /**
     * 思路：先序遍历处理会破坏二叉树的结构，没法遍历后续节点，所以采用先序遍历的倒序来处理
     * @param root
     */
    public void transform(TreeNode root) {
        if (root != null) {
//            root.left = preNode;
            if (preNode != null) {
                preNode.right = root;
            }
            preNode = root;

            transform(root.left);
            transform(root.right);
        }
    }

    public void flatten(TreeNode root) {
        if (root != null) {
            flatten(root.right);
            flatten(root.left);

            root.right = preNode;
            root.left = null;
            preNode = root;
        }
    }
}
