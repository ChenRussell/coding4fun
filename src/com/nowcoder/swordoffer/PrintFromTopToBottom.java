package com.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ChenRui on 18-3-28
 * <p>
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root!=null) que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll(); // 返回第一个元素，并在队列中删除（出队列）
//            System.out.println(node.val);
            arr.add(node.val);
            if (node.left!=null) que.offer(node.left);
            if(node.right!=null) que.offer(node.right);
        }
        return arr;
    }

    public static void main(String[] args) {
        PrintFromTopToBottom obj = new PrintFromTopToBottom();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = null;
        node.right.right = null;

        node.left.left = new TreeNode(5);
        node.left.right = null;
        ArrayList<Integer> arr = obj.printFromTopToBottom(node);
        arr.forEach(System.out::println);
//        System.out.println(arr);
//        arr.forEach(x-> System.out.println(x));

    }
}
