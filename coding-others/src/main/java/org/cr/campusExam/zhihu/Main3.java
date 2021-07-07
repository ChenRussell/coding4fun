package org.cr.campusExam.zhihu;

import java.util.Scanner;

/**
 * 题目名称：走楼梯
 * 时间限制：1000ms
 * 题目描述：现在有一截楼梯，根据你的腿长，你一次能走 1 级或 2 级楼梯，
 * 已知你要走 n 级楼梯才能走到你的目的楼层，请实现一个方法，计算你走到目的楼层的方案数。
 * （测试用例仅做参考，我们会根据代码质量进行评分）
 * <p>
 * 输入描述：输入整数n。(1<=n<=50)
 * <p>
 * 输出描述：输出方案数。
 * 示例1
 * 输入
 * 5
 * 输出
 * 8
 */
public class Main3 {

    static int count  = 0;
    static void f(int n) {
        if (n == 0) {
            count++;
        } else if (n > 0) {
            f(n - 1);
            f(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
        System.out.println(count);
    }
}
