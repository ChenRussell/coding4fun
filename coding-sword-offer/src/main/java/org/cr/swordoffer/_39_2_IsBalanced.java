package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-4-14
 * <p>
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 */
public class _39_2_IsBalanced {

    public boolean IsBalanced_Solution(TreeNode root) {

        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode root) {

        if (root == null) return 0;
        int left = checkBalance(root.left);
        if (left == -1) return -1;  // �����������ƽ��ͷ���-1
        int right = checkBalance(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;   // ������ȣ���ƽ���򷵻�-1
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        boolean res = new _39_2_IsBalanced().IsBalanced_Solution(root);
        System.out.println(res);
    }
}
