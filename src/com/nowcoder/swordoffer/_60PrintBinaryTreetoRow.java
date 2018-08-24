package com.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ChenRui on 18-4-15
 * <p>
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class _60PrintBinaryTreetoRow {

    static void Print(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int nextLevelCount = 0;     // 下一层节点的个数
        int leftToPrint = 1;        // 当前层剩下没有打印的节点
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            leftToPrint--;
            if (node.left != null) {
                queue.offer(node.left);
                nextLevelCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelCount++;
            }

            // 当前层节点打印完成后，重新赋值
            if (leftToPrint == 0) {
                System.out.println();
                leftToPrint = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) return list;
        queue.offer(pRoot);

        int nextLevelCount = 0;
        int leftToPrint = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            leftToPrint--;
            temp.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nextLevelCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelCount++;
            }

            if (leftToPrint == 0) {
                list.add(temp);
                temp = new ArrayList<>();
                leftToPrint = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(6);
        node.right.right = new TreeNode(12);
        node.right.left = new TreeNode(21);
//        Print(node);
        List<ArrayList<Integer>> res = Print2(node);
        System.out.println(res);
    }
}
