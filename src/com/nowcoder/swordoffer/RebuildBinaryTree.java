package com.nowcoder.swordoffer;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class RebuildBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int pleft, int pright, int ileft, int iright) {
        if (pleft > pright || ileft > iright) return null;  // 递归边界

        int root = pre[pleft];  // 根元素，不是pre[0]
        TreeNode treeNode = new TreeNode(root);
        treeNode.left = null;
        treeNode.right = null;

        for (int i = ileft; i <= iright; i++) { // 循环是从中序的开始到结尾，而不是0到in.length
            if (in[i] == root) {    // i-ileft 相对大小
                treeNode.left = reConstructBinaryTree(pre, in, pleft + 1, pleft + i - ileft, ileft, i - 1);  // 关键位置是pright:pleft+(i-ileft),因为循环是从ileft开始，所以需要减去ileft得到相对大小
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

    // 先序遍历二叉树
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
        RebuildBinaryTree rebuildBinaryTree = new RebuildBinaryTree();
        TreeNode treeNode = rebuildBinaryTree.reConstructBinaryTree(pre, in);
        rebuildBinaryTree.preTraverse(treeNode);

    }
}
