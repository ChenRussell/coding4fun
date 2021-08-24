package org.cr.leetcode.binarytree;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/22
 * <p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Follow up: Could you solve it both recursively and iteratively?
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class _101SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode != null) {
            return false;
        } else if (leftNode != null && rightNode == null) {
            return false;
        } else if (leftNode == null) {
            return true;
        } else if (leftNode.val != rightNode.val) {
            return false;
        }
        return check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric_voted(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public static void main(String[] args) {
        _101SymmetricTree symmetricTree = new _101SymmetricTree();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(symmetricTree.isSymmetric(treeNode));
    }
}
