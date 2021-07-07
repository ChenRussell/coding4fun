package org.cr.swordoffer;


/**
 * Created by ChenRui on 2018/3/20
 * ��Ŀ����
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 */
public class _18_CheckSubTree {

    /**
     * ��ôд���а�
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;    // ���ﵽ�׷���ʲô�������ܹؼ��� ����ط���Ӳ�ˣ�������
        if (root1==null) return true;   // ʡ��дroot2==null

        if (root1.val == root2.val){
            return (HasSubtree(root1.left, root2.left) && HasSubtree(root1.right, root2.right)) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }else{
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }

    boolean hasSubtree2(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = check(root1, root2);
            }
            if (!result){
                result = hasSubtree2(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree2(root1.right, root2);
            }
        }

        return result;
    }

    boolean check(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;

        if (root1.val != root2.val) {
            return false;
        }

        return check(root1.left, root2.left) && check(root1.right, root2.right);
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.left.left = null;
        treeNode1.left.right = null;
        treeNode1.right = new TreeNode(3);
        treeNode1.right.left = null;
        treeNode1.right.right = null;

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = null;
        treeNode2.right = null;

        _18_CheckSubTree checkSubTree = new _18_CheckSubTree();
        boolean bool = checkSubTree.hasSubtree2(treeNode1, treeNode2);
        System.out.println(bool);
    }
}
