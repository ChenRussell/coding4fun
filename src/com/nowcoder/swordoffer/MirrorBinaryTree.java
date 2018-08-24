package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-3-26
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorBinaryTree {

    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            Mirror(root.left);
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        MirrorBinaryTree obj = new MirrorBinaryTree();
        obj.Mirror(node);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
    }
}
