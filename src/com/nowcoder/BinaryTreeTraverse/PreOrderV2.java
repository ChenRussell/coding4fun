package com.nowcoder.BinaryTreeTraverse;

import java.util.Stack;

/**
 * Created by ChenRui on 18-4-13
 */
public class PreOrderV2 {

    /**
     * 只有一个while循环
     * @param root
     */
    static void preOrderV2(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p!=null || !stack.isEmpty()) {

            if (p != null) {
                stack.push(p);
                // 先序遍历
//                System.out.println(p.value);
                p = p.left;
            } else {
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
        preOrderV2(node);
    }
}
