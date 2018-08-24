package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-4-17
 * <p>
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class _59IsSymmetrical {

    static boolean isSymmetrical(TreeNode pRoot) {
        return checkSymmetrical(pRoot, pRoot);
    }

    private static boolean checkSymmetrical(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        // 先序遍历 && 先序遍历的对称遍历(先右后左)
        return checkSymmetrical(node1.left, node2.right)
                &&checkSymmetrical(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(3);
        boolean res = isSymmetrical(node);
        System.out.println(res);
    }
}
