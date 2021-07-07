package org.cr.swordoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ChenRui on 18-4-15
 * ��Ŀ����
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
 * �ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 */
public class _61PrintZ {

    static public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>(); // �洢�����У��������Ƚ�ջ�����������ջ
        Stack<TreeNode> stack2 = new Stack<>(); // �洢ż���У��������Ƚ�ջ�����������ջ

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        stack1.push(pRoot);

        boolean flag = true;    // true����������false����ż��
        ArrayList<Integer> temp = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) { // �����㣬 ������stack2
                TreeNode node = stack1.pop();
                temp.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            } else {   // ż���㣬������stack1
                TreeNode node = stack2.pop();
                temp.add(node.val);
                // �������Ƚ�ջ
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }

            // ��stack1Ϊ��ʱ��˵�����뵽ż����
            if (stack1.isEmpty() && flag) {
                flag = false;
                if(temp.size()>0) res.add(temp);
                temp = new ArrayList<>();
            }
            // ��stack2Ϊ��ʱ��˵�����뵽������, �����ж�Ҫ���ϣ�flag, Ҷ�ӽڵ������Ϊ�գ��жϻ�������
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
