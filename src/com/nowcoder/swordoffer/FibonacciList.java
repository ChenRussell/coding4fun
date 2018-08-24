package com.nowcoder.swordoffer;

import com.sun.org.apache.bcel.internal.generic.F2D;

/**
 * Created by ChenRui on 2018/2/19
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class FibonacciList {
    public int Fibonacci(int n) {
        int result = 0;
        int f1 = 0, f2 = 1;
        if (n <= 1) return n;
        for (int i = 2; i <= n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }

    private int Fibonacci2(int n) {
        if (n <= 1) return n;
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }

    public static void main(String[] args) {
        int fibonacci = new FibonacciList().Fibonacci(5);
        System.out.println(fibonacci);
    }
}
