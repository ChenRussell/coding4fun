package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-4-14
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {

    public boolean IsBalanced_Solution(TreeNode root) {

        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode root) {

        if (root == null) return 0;
        int left = checkBalance(root.left);
        if (left == -1) return -1;  // 如果左子树不平衡就返回-1
        int right = checkBalance(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;   // 返回深度，不平衡则返回-1
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        boolean res = new IsBalanced().IsBalanced_Solution(root);
        System.out.println(res);
    }
}
