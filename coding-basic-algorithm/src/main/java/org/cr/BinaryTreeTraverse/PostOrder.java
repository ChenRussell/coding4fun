package org.cr.BinaryTreeTraverse;

import java.util.Stack;

/**
 * Created by ChenRui on 18-4-13
 */
public class PostOrder {

    /**
     * ��������ݹ鶨�壺���������������������ٸ��ڵ㡣����������ѵ����ڣ�
     * ��Ҫ�ж��ϴη��ʵĽڵ���λ��������������������������λ���������������������ڵ㣬�Ƚ�����������
     * �ٻ�ͷ���ʸ��ڵ㣻����λ������������ֱ�ӷ��ʸ��ڵ㡣ֱ�ӿ����룬����������ϸ��ע�͡�
     * @param root
     */
    static void postOrder(TreeNode root) {

        TreeNode p = root;
        // ��¼��һ�������ʵĽڵ�
        TreeNode pLastVisit = null;
        Stack<TreeNode> stack = new Stack<>();

        // ���Ƶ����������±�
        while (p != null) {
            stack.push(p);
            p = p.left;
        }

        while (!stack.isEmpty()) {

            // ���ڵ��ջ
            p = stack.pop();

            // һ�����ڵ㱻���ʵ�ǰ���ǣ������������������Ѿ������ʹ�
            if (p.right == null || pLastVisit == p.right) {
                System.out.println(p.value);
                pLastVisit = p;
            } else {    // ��ʱ������һ����Ϊ��
                // ���ڵ��ٴ���ջ
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
