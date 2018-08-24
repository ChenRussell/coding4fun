package com.nowcoder.BinaryTreeTraverse;

import java.util.Stack;

/**
 * Created by ChenRui on 18-4-13
 */
public class PostOrder {

    /**
     * 后序遍历递归定义：先左子树，后右子树，再根节点。后序遍历的难点在于：
     * 需要判断上次访问的节点是位于左子树，还是右子树。若是位于左子树，则需跳过根节点，先进入右子树，
     * 再回头访问根节点；若是位于右子树，则直接访问根节点。直接看代码，代码中有详细的注释。
     * @param root
     */
    static void postOrder(TreeNode root) {

        TreeNode p = root;
        // 记录上一个被访问的节点
        TreeNode pLastVisit = null;
        Stack<TreeNode> stack = new Stack<>();

        // 先移到左子树最下边
        while (p != null) {
            stack.push(p);
            p = p.left;
        }

        while (!stack.isEmpty()) {

            // 根节点出栈
            p = stack.pop();

            // 一个根节点被访问的前提是：无右子树或右子树已经被访问过
            if (p.right == null || pLastVisit == p.right) {
                System.out.println(p.value);
                pLastVisit = p;
            } else {    // 此时右子树一定不为空
                // 根节点再次入栈
                stack.push(p);
                p = p.right;
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
            }
        }
    }

    private static void postOrderRecursion(TreeNode node) {
        if (node != null) {
            postOrderRecursion(node.left);
            postOrderRecursion(node.right);
            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(4);
        node.left.right = null;
//        postOrder(node);
        postOrderRecursion(node);
    }
}
