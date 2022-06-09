package org.cr.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/09/13
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class _199BinaryTreeRightSideView {

    /**
     * (1) the traverse of the tree is NOT standard pre-order traverse. It checks the RIGHT node first and then the LEFT
     * (2) the line to check currDepth == result.size() makes sure the first element of that level will be added to the result list
     * (3) if reverse the visit order, that is first LEFT and then RIGHT, it will return the left view of the tree.
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        getRightSideView(root, res, 0);
        return res;
    }

    public void getRightSideView(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            res.add(root.val);
        }
        getRightSideView(root.right, res, depth+1);
        getRightSideView(root.left, res, depth+1);
    }
}
