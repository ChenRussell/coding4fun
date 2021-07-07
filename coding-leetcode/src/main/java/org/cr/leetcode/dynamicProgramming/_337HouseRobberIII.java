package org.cr.leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into
 * on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * Input: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * 详解：https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 */
public class _337HouseRobberIII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // ONE
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    // TWO
    public int rob2(TreeNode root) {
        return robSub2(root, new HashMap<>());
    }

    private int robSub2(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub2(root.left.left, map) + robSub2(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub2(root.right.left, map) + robSub2(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub2(root.left, map) + robSub2(root.right, map));
        map.put(root, val);

        return val;
    }

    // THREE
    public int rob3(TreeNode root) {
        int[] res = robSub3(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub3(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub3(root.left);
        int[] right = robSub3(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];     // 1代表被抢，0代表没有被抢

        return res;
    }

    public static void main(String[] args) {

    }
}
