package org.cr.swordoffer;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class _6_RebuildBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int pleft, int pright, int ileft, int iright) {
        if (pleft > pright || ileft > iright) return null;  // �ݹ�߽�

        int root = pre[pleft];  // ��Ԫ�أ�����pre[0]
        TreeNode treeNode = new TreeNode(root);
        treeNode.left = null;
        treeNode.right = null;

        for (int i = ileft; i <= iright; i++) { // ѭ���Ǵ�����Ŀ�ʼ����β��������0��in.length
            if (in[i] == root) {    // i-ileft ��Դ�С
                treeNode.left = reConstructBinaryTree(pre, in, pleft + 1, pleft + i - ileft, ileft, i - 1);  // �ؼ�λ����pright:pleft+(i-ileft),��Ϊѭ���Ǵ�ileft��ʼ��������Ҫ��ȥileft�õ���Դ�С
                treeNode.right = reConstructBinaryTree(pre, in, pleft + i + 1 - ileft, pright, i + 1, iright);
                break;
            }
        }
        return treeNode;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return treeNode;
    }

    // �������������
    public void preTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            preTraverse(treeNode.left);
            preTraverse(treeNode.right);
        }
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {4,7,2,1,5,3,8,6};
//        int[] in = {3, 2, 4, 1, 6, 5, 7};
        _6_RebuildBinaryTree rebuildBinaryTree = new _6_RebuildBinaryTree();
        TreeNode treeNode = rebuildBinaryTree.reConstructBinaryTree(pre, in);
        rebuildBinaryTree.preTraverse(treeNode);

    }
}
