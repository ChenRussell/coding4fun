package org.cr.leetcode.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/23
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
public class _297SerializeAndDeserializeBinaryTree {

    static class Codec {

        public static final String SPLIT = ",";
        public static final String NULL_VAL = "N";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.substring(0, sb.length()-1);
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NULL_VAL).append(SPLIT);
            } else {
                sb.append(node.val).append(SPLIT);
                buildString(node.left, sb);
                buildString(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return buildTree(new LinkedList<>(Arrays.asList(data.split(SPLIT))));
        }

        // 这种序列化方式不能通过idx找到左右子树，可通过队列的方式处理
        private TreeNode buildTree(Queue<String> data) {
            String val = data.remove();
            if (val.equals(NULL_VAL)) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(val));
                node.left = buildTree(data);
                node.right = buildTree(data);
                return node;
            }
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        String serialize = codec.serialize(node);
        System.out.println(serialize);
        System.out.println(codec.deserialize(serialize).val);
        System.out.println(codec.deserialize(serialize).left.val);
        System.out.println(codec.deserialize(serialize).right.val);
        System.out.println(Arrays.stream("1,2,3,".split(",")).collect(Collectors.toList()));
        System.out.println("1,2,".split(",").length);
    }
}
