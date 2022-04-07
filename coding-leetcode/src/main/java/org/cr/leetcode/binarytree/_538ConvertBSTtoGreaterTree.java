package org.cr.leetcode.binarytree;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/03/31
 */
public class _538ConvertBSTtoGreaterTree {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST_voted(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
