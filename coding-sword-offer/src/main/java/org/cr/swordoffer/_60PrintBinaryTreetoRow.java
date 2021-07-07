package org.cr.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ChenRui on 18-4-15
 * <p>
 * ���ϵ��°����ӡ��������ͬһ��Ľڵ㰴�����ҵ�˳���ӡ��ÿһ���ӡ��һ�С�
 */
public class _60PrintBinaryTreetoRow {

    static void Print(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int nextLevelCount = 0;     // ��һ��ڵ�ĸ���
        int leftToPrint = 1;        // ��ǰ��ʣ��û�д�ӡ�Ľڵ�
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

            // ��ǰ��ڵ��ӡ��ɺ����¸�ֵ
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
