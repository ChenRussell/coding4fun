package org.cr.campusExam.aiqiyi;

/**
 * Created by ChenRui on 2018/9/15
 * <p>
 * 题目描述：
 * 局长有N种食物，每种食物有Ai份。
 * <p>
 * 每天局长会吃一份食物，或者买一份食物（即每天只能进行吃或买其中的一种动作），这样过了M天
 * <p>
 * 现在局长想知道M天后第p种食物的份数排名（从大到小，相同算并列，例如3 3 2，则排名为1 1 3）
 * <p>
 * N,M,P<=100,Ai<=1000
 * <p>
 * 输入
 * 第一行N M P
 * <p>
 * 第二行N个数Ai
 * <p>
 * 接下来M行，每行A i或者B i分别表示买一份食物i，吃一份食物i
 * <p>
 * 输出
 * 一个答案
 * <p>
 * <p>
 * 样例输入
 * 3 4 2
 * 5 3 1
 * B 1
 * A 2
 * A 2
 * A 3
 * 样例输出
 * 1
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i <= n-1; i++) {
            a[i] = sc.nextInt();
        }
        sc.nextLine();
        String[] food = new String[m];
        for (int i = 0; i <= m-1; i++) {
            food[i] = sc.nextLine();
        }
        for (int i = 0; i <= m-1; i++) {
            String[] inStr = food[i].split(" ");
            int index = Integer.valueOf(inStr[1]) - 1;
            if ("A".equals(inStr[0])) {
                a[index] += 1;
            } else {
                a[index] -= 1;
            }
        }
        int res = 1;
        int has = a[p - 1];
        Arrays.sort(a);
        int i = a.length - 1;
        while (i >= 0) {
            if (has < a[i]) {
                res+=1;
            }else break;
            i--;
        }
        System.out.println(res);
    }
}
