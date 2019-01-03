package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 2018/9/25.
 * <p>
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _27Convert {

    TreeNode lastNodeInList = null;     // 定义一个全局变量，如果是参数传入的话带不回来

    public TreeNode convert(TreeNode pRootOfTree) {


        convertNode(pRootOfTree);

        while (lastNodeInList!=null && lastNodeInList.left != null) {
            lastNodeInList = lastNodeInList.left;
        }

        return lastNodeInList;
    }

    // 使用中序遍历
    private void convertNode(TreeNode pRootOfTree) {

        if (pRootOfTree != null) {
            convertNode(pRootOfTree.left);

            pRootOfTree.left = lastNodeInList;

            if (lastNodeInList != null) {
                lastNodeInList.right = pRootOfTree;
            }
            lastNodeInList = pRootOfTree;   // 更新lastNodeInList

            convertNode(pRootOfTree.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        _27Convert convert = new _27Convert();
        TreeNode head = convert.convert(node);
        TreeNode pre = null;
        while (head != null) {
            System.out.println(head.val);
            pre = head;
            head = head.right;
        }


        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.left;
        }
    }
}
