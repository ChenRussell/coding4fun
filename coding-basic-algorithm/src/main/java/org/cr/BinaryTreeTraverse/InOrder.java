package org.cr.BinaryTreeTraverse;

import java.util.Stack;

/**
 * Created by ChenRui on 18-4-13
 */

public class InOrder {

    private static Stack<TreeNode> stack = new Stack<>();

    public static void inOrder(TreeNode head){
        TreeNode p = head;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
//                System.out.println(p.value);
                p = p.left;
            }

            if (!stack.isEmpty()) { // 出栈之前判断是否为空
                p = stack.pop();
                System.out.println(p.value);
                p = p.right;
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
        inOrder(node);
    }
}
