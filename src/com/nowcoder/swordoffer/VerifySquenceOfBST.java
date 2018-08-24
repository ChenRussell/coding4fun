package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-3-28
 * <p>
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence.length ==0) return false;
        int root = sequence[sequence.length - 1];

        boolean bool = checkBST(sequence, 0, sequence.length - 1);
        return bool;
    }

    boolean checkBST(int seq[], int start, int end) {
        if (start >=end) return true;   // tag-1 传过来可能end<0,所以这里start>=end
        int root = seq[end];
        int tag=0;
        boolean flag = false;
        for (int i = start; i < end; i++) {
            if (seq[i]>root) {
                tag=i;
                flag = true;    // 代表能找到大于root的
                break;
            }
        }

        // 当找不着大于root的时候，tag=0, tag-1 传过去会报错
        for (int i = tag; i < end && flag; i++) {
            if (seq[i]<root)
                return false;
        }
//        return true;
        boolean left=true;
//        if (end>0)
        left= checkBST(seq, start, tag-1);

        boolean right = true;
//        if (end>0)
        right = checkBST(seq, tag, end-1);

        return left && right ;

    }

    public static void main(String[] args) {
        int arr[] = {5,7,6,9,11,10,8};
        int arr2[] = {4,6,7,5};
        VerifySquenceOfBST obj = new VerifySquenceOfBST();
        boolean bool = obj.checkBST(arr2, 0, arr2.length - 1);
        System.out.println(bool);
    }
}
