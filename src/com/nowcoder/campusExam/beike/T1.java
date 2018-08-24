package com.nowcoder.campusExam.beike;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/8/18
 *
 * 数列的定义如下： 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * <p>
 * 输入
 * 输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 * <p>
 * 输出
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 * <p>
 * <p>
 * 样例输入
 * 81 4
 * 2 2
 * <p>
 * 样例输出
 * 94.73
 * 3.41
 */
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            double sum = n;
            double temp = n;
            for (int i = 0; i < m-1; i++) {
                temp = Math.sqrt(temp);
                sum += temp;
            }
            System.out.printf("%.2f", sum);
        }
    }
}
