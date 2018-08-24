package com.nowcoder.campusExam.byteDance;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/3/24
 *
 * 定义两个字符串变量：s和m，再定义两种操作，
 * 第一种操作：
 *  m = s；
 *  s = s+s；
 * 第二种操作：
 *  s = s + m；
 *  假设s，m初始化如下：
 *  s = “a”；
 *  m = s；
 *
 *  求最小的操作步骤数，可以将s拼接到长度等于n
 */
public class Tone {

    static int min = Integer.MAX_VALUE;
    static void f(int s, int m, int i, int j, int n) {
        if (s == n) {
            if (i+j < min)  min = i+j;
//            System.out.println(i+" "+j);
//            System.out.println(min);
        }else if (s < n){

            f(s * 2, s, i + 1, j, n);
            f(s + m, m, i, j + 1, n);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(1,1,0,0,n);
        System.out.println(min);
    }
}
