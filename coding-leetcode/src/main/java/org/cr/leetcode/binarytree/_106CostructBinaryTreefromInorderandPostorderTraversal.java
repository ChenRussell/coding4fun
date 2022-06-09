package org.cr.leetcode.binarytree;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/24
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class _106CostructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if (instart > inend || poststart > postend) return null;

        int root = postorder[postend];
        TreeNode node = new TreeNode(root);
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == root) {
                node.left = buildTree(inorder, postorder, instart, i - 1, poststart, poststart + i - instart -1);
                node.right = buildTree(inorder, postorder, i + 1, inend, poststart + i - instart, postend-1);
                break;
            }
        }
        return node;
    }
}
