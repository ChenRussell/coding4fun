package com.nowcoder.BinaryTreeTraverse;


import java.util.Stack;

/**
 * Created by ChenRui on 18-4-13
 */
class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class PreOrder {

    static void preOrder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                // 先序遍历打印
//                System.out.println(p.value);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                // 中序遍历打印
                System.out.println(pop.value);
                p = pop.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(4);
        node.left.right = null;
        preOrder(node);
    }
}
