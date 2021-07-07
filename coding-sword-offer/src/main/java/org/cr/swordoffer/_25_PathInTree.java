package org.cr.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ChenRui on 2018/3/30
 * <p>
 * ��Ŀ����
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��  Ҷ���  �������Ľ���γ�һ��·����
 */
public class _25_PathInTree {

    class Int {
        int value;

        public Int(int value) {
            this.value = value;
        }
    }

    public ArrayList<ArrayList<Integer>> findPath2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

//        int sum = 0;
        Int sum = new Int(0);
        findFuckingPath(root, target, arr, stack, sum);


        return arr;
    }

    private void findFuckingPath(TreeNode root,
                                 int target,
                                 ArrayList<ArrayList<Integer>> arr,
                                 Stack<Integer> stack,
                                 Int sum) {

        if (root != null) {
            sum.value += root.val;
            stack.push(root.val);

            if (root.left == null && root.right == null) {
                if (sum.value == target) {
                    ArrayList<Integer> list = new ArrayList<>(stack);
//                    stack.forEach(x->list.add(x));
                    arr.add(list);
                }
            }

            findFuckingPath(root.left, target, arr, stack, sum);
            findFuckingPath(root.right, target, arr, stack, sum);
            stack.pop();    // ���ݹ鷵�ص�֮ǰִ�е���λ��ʱ��stack�ѵ�����֮ǰ��ֵ�� Ϊɶsum����֮ǰ��ֵ
            sum.value -= root.val;  // �Զ������ͣ��˻���һ��ʱ����Ҫ��ȥ���ֵ����int��������Ҫ��ʹ�õ�����һ��ջ֡�ﱣ���ֵ
            // ???WHY???  ��Ϊstack���������ͣ��൱��ָ�룬����ǵ�ַ�����˻���һ��ʱ��������ֵ����һ��ջ֡�ﱣ���ֵ����ͬһ����ֵַ����int���͵ı�������һ��ջ֡���ֵ�ǲ�һ����
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
        _25_PathInTree obj = new _25_PathInTree();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(2);
        node.left.right = null;

        ArrayList<ArrayList<Integer>> path = obj.findPath2(node, 6);
        System.out.println("size: "+path.size());
        for (int i = 0; i < path.size(); i++) {
//            path.get(i).forEach(System.out::println);
            for (Integer integer : path.get(i)) {
                System.out.println(integer);
            }
            System.out.println("*******");
        }
    }
}
