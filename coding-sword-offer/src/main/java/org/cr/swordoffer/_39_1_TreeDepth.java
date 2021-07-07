package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/3/30
 * <p>
 * ��Ŀ����
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class _39_1_TreeDepth {

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        _39_1_TreeDepth obj = new _39_1_TreeDepth();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(2);
//        node.left.right = null;
        System.out.println(obj.depth(node));
    }
}
