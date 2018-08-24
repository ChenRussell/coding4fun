package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-3-8
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 考点:　考虑全面，各种边界值
 */
public class Power {
    public double power(double base, int exponent) {
        double result = 1;
        int n = Math.abs(exponent);
        for (int i = 0; i < n; i++) {
            result *= base;
        }
        if (base == 0) return 0;
        if (exponent<0) return 1/result;
        return result;
    }

    public static void main(String[] args) {
        Power power = new Power();
        double res = power.power(0, -2);
        System.out.println(res);
    }
}
