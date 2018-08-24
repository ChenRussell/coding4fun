package com.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ChenRui on 2018/3/30
 * <p>
 * 题目描述
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到  叶结点  所经过的结点形成一条路径。
 */
public class FindPath {

    public ArrayList<ArrayList<Integer>> findPath2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        findFuckingPath(root, target, arr, stack, sum);


        return arr;
    }

    private void findFuckingPath(TreeNode root,
                                 int target,
                                 ArrayList<ArrayList<Integer>> arr,
                                 Stack<Integer> stack,
                                 int sum) {

        if (root != null) {
            sum += root.val;
            stack.push(root.val);

            if (root.left == null && root.right == null) {
                if (sum == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.addAll(stack);
//                    stack.forEach(x->list.add(x));
                    arr.add(list);
                }
            }

            findFuckingPath(root.left, target, arr, stack, sum);
            findFuckingPath(root.right, target, arr, stack, sum);
            stack.pop();    // 当递归返回到之前执行到的位置时，stack难道不是之前的值吗？ 为啥sum会是之前的值
            // ???WHY???
        }
    }

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (!stack.empty() || root!=null) {
            while (root != null) {
                sum += root.val;
                stack.push(root);
                root = root.left;
                if (sum == target) checkEqual(arr,stack, sum, target);
            }

            if (!stack.empty()) {
                TreeNode pop = stack.pop();
                sum -= pop.val;
                root = pop.right;
            }
//            if (sum == target)
        }
        return arr;
    }

    void checkEqual(ArrayList<ArrayList<Integer>> arr,Stack<TreeNode> stack, int sum, int target) {
        ArrayList<Integer> list = new ArrayList<>();
//        if (sum == target) {
//            list.addAll(stack);
//            stack.forEach(x->list.addAll());
//            Collection.add
            for (TreeNode o : stack) {
                list.add(o.val);
            }
//        }
        arr.add(list);
    }

    public static void main(String[] args) {
        FindPath obj = new FindPath();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(2);
        node.left.right = null;

        ArrayList<ArrayList<Integer>> path = obj.findPath2(node, 6);
        System.out.println(path.size());
        for (int i = 0; i < path.size(); i++) {
//            path.get(i).forEach(System.out::println);
            for (Integer integer : path.get(i)) {
                System.out.println(integer);
            }
            System.out.println("*******");
        }
    }
}
