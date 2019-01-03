package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 2018/9/27.
 *
 *
 */
public class CountLeafNode {

    public int countLeafNode(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNode(node.left) + countLeafNode(node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
//        node.left.right = new TreeNode(5);

        CountLeafNode countLeafNode = new CountLeafNode();
        int res = countLeafNode.countLeafNode(node);
        System.out.println(res);
    }
}
