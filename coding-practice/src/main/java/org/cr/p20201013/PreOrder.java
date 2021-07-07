package org.cr.p20201013;


import java.util.Stack;

/**
 * @Description
 * @auther chenrui
 * @create 2020-10-14 14:43
 */

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}

public class PreOrder {

    private static Stack<TreeNode> stack = new Stack<TreeNode>();

    public static void preOrder(TreeNode node) {

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                System.out.println(node.value);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                TreeNode p = stack.pop();
//                System.out.println(p.value);
                node = p.right;
            }
        }
    }

    public static void postOrder(TreeNode node) {
        TreeNode p = node;
        TreeNode pLastVisited = null;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }

        while (!stack.isEmpty()) {
            p = stack.pop();
            if (p.right == null || p.right == pLastVisited) {
                System.out.println(p.value);
                pLastVisited = p;
            } else {
                stack.push(p);
                p = p.right;
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
            }
        }
    }

    public static void order(TreeNode node) {
        if (node != null) {
            order(node.left);
            order(node.right);
            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(4);
        node.left.right = null;
        order(node);
    }
}
