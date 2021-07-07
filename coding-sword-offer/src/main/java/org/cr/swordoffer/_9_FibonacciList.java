package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/2/19
 * ��Ŀ����
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
 * n<=39
 */
public class _9_FibonacciList {
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
        int fibonacci = new _9_FibonacciList().Fibonacci(5);
        System.out.println(fibonacci);
    }
}
