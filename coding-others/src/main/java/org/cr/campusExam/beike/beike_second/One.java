package org.cr.campusExam.beike.beike_second;
/**
 * 假设有这样一个计算器，该计算器只有两个按钮，按下第一个按钮能使显示数值减少1，
 *
 * 按下第二个按钮能使显示数值乘以2，当前显示数值为N，那么至少要按多少次按钮才能使显示数值变成M？
 * <p>
 * 输入
 * 输入两个整数N和M，1≤N，M≤109。
 * <p>
 * 输出
 * 输出使显示数值变成M的最少按按钮次数。
 * <p>
 * <p>
 * 样例输入
 * 4 5
 * 样例输出
 * 3
 */

import java.util.Scanner;

public class One {

    static int result = 0;

    static void f(int n, int m, int count) {
        if (n < 0) return;

        if (n == m) {
            result = count;
            return;
        }

        f(n - 1, m, count + 1);
        if (n < m) f(n * 2, m, count + 1);

    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        f(n, m, 0);
//        System.out.println(result);
      /*  Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m = scanner.nextInt();
        long count =0;
        if(m/2 != 0) {
            m++;
            count++;
        }

        while(m > n) {
            m = m/2;
            count++;
        }
        count += (n-m);
        System.out.println(count);*/

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int res = 0;
        if (m > n) {
            System.out.println(m - n);
            return;
        }
        if (m == n) {
            System.out.println(0);
            return;
        }
        int p = n + 1;
        p = p * 2;
        while (m < p / 2) {
            res++;
            p = p / 2;
        }
        res += m - p / 2;
        if (n % 2 == 0) System.out.println(res);
        else System.out.println(res + 1);
    }
}
