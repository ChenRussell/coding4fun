package com.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ChenRui on 18-4-15
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class _61PrintZ {

    static public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>(); // 存储奇数行，左子树先进栈，右子树后进栈
        Stack<TreeNode> stack2 = new Stack<>(); // 存储偶数行，右子树先进栈，左子树后进栈

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        stack1.push(pRoot);

        boolean flag = true;    // true代表奇数，false代表偶数
        ArrayList<Integer> temp = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) { // 奇数层， 子树进stack2
                TreeNode node = stack1.pop();
                temp.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            } else {   // 偶数层，子树进stack1
                TreeNode node = stack2.pop();
                temp.add(node.val);
                // 右子树先进栈
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }

            // 当stack1为空时，说明进入到偶数层
            if (stack1.isEmpty() && flag) {
                flag = false;
                if(temp.size()>0) res.add(temp);
                temp = new ArrayList<>();
            }
            // 当stack2为空时，说明进入到奇数层, 条件判断要加上！flag, 叶子节点的子树为空，判断会有问题
            if (stack2.isEmpty() && !flag) {
                flag = true;
                if(temp.size()>0) res.add(temp);
                temp = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(6);
//        node.right.left = new TreeNode(7);
//        node.right.right = new TreeNode(8);

        List<ArrayList<Integer>> res = Print(node);
        System.out.println(res);
    }
}
