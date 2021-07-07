package org.cr.campusExam.zhihu;

import java.util.Scanner;

/**
 * 题目名称：非降序数组
 * 时间限制：1000ms
 * 题目描述：写一个函数，传入两个非降序的整数数组（A, B），将 A, B 合并成一个非降序数组 C，
 * 返回 C（不要使用内置 sort 函数）。（测试用例仅做参考，我们会根据代码质量进行评分）
 * <p>
 * 输入描述：第一行输入两个整数n,m。（1<=n,m<=100000）分别表示数组A,B的大小。
 * 第二行给出n个整数a。(1<=a<=10000)
 * 第三行给出m个整数b。(1<=b<=10000)
 * <p>
 * 输出描述：输出合并之后排序好的数组。
 * 示例1
 * 输入
 * 3 3
 * 1 9 10
 * 3 12 41
 * 输出
 * 1 3 9 10 12 41
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] res = new int[n + m];

        int i = 0, j = 0, k=0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < n) {
            res[k++] = arr1[i++];
        }
        while (j < m) {
            res[k++] = arr2[j++];
        }

        for (int re : res) {
            System.out.print(re+" ");
        }
    }
}
