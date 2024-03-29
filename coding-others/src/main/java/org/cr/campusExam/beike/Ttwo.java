package org.cr.campusExam.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ChenRui on 2018/8/18
 * <p>
 * 题目描述：
 * 山区里有N个村庄，第i个村庄的海拔高度为Ai。现在要在村庄之间修建道路，使得从每个村庄出发，都能到达其它所有村庄。在第i和第j个村庄之间修建道路的费用取决于海拔较高的村庄的高度，即费用为max{Ai，Aj}，那么修建道路的总费用最少是多少？
 * <p>
 * 输入
 * 第一行包含一个整数N，2≤N≤105。
 * <p>
 * 第二行包含N个空格隔开的整数A1到AN，0≤Ai≤104。
 * <p>
 * 输出
 * 输出修建道路的最小费用。
 * <p>
 * <p>
 * 样例输入
 * 5
 * 4 1 8 2 5
 * 样例输出
 * 19
 */
public class Ttwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
