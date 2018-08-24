package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 2018/2/19
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    private int jumpFloorII(int target) {
        int result = 1;
        if (target < 1) return 0;
        else if (target == 1) return 1;
        for (int i = 2; i <= target; i++) {
            result *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new JumpFloorII().jumpFloorII(3);
        System.out.println(i);
    }
}
