package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-4-15
 */
public class _63KthNode {

    static int count = 0;
    static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;

        TreeNode left = KthNode(pRoot.left, k);
        count++;
        if (count == k) return pRoot;
        TreeNode right = KthNode(pRoot.right, k);
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        TreeNode res = KthNode(node, 4);
        System.out.println(res.val);
    }
}
