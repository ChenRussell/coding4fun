package org.cr.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ChenRui on 18-3-28
 * <p>
 * ��Ŀ����
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 */
public class _23_PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root!=null) que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll(); // ���ص�һ��Ԫ�أ����ڶ�����ɾ���������У�
//            System.out.println(node.val);
            arr.add(node.val);
            if (node.left!=null) que.offer(node.left);
            if(node.right!=null) que.offer(node.right);
        }
        return arr;
    }

    public static void main(String[] args) {
        _23_PrintFromTopToBottom obj = new _23_PrintFromTopToBottom();
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
