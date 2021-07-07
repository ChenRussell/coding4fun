package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-4-17
 * <p>
 * ��Ŀ����
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 */
public class _59IsSymmetrical {

    static boolean isSymmetrical(TreeNode pRoot) {
        return checkSymmetrical(pRoot, pRoot);
    }

    private static boolean checkSymmetrical(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        // ������� && ��������ĶԳƱ���(���Һ���)
        return checkSymmetrical(node1.left, node2.right)
                &&checkSymmetrical(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(3);
        boolean res = isSymmetrical(node);
        System.out.println(res);
    }
}
