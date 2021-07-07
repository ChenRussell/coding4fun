package org.cr.campusExam.aiqiyi;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/9/15
 * <p>
 * 小C有一张票，这张票的ID是长度为6的字符串，每个字符都是数字，他想让这个ID变成他的辛运ID，所以他就开始更改ID，每一次操作，他可以选择任意一个数字并且替换它。
 * <p>
 * 如果这个ID的前三位数字之和等于后三位数字之和，那么这个ID就是辛运的。你帮小C求一下，最少需要操作几次，能使ID变成辛运ID
 * <p>
 * 输入
 * 输入只有一行，是一个长度为6的字符串。
 * <p>
 * 输出
 * 输出这个最小操作次数
 * <p>
 * <p>
 * 样例输入
 * 000000
 * 样例输出
 * 0
 * <p>
 * Hint
 * 输入样例2
 * 000018
 * <p>
 * 输出样例2
 * 1
 * <p>
 * 样例解释：将前三位任意一个改为9即可满足条件，操作数为1
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char[] chars = str.toCharArray();

        int sum1=0, sum2=0;
        for (int i = 0; i < chars.length-3; i++) {
            sum1 += (int) chars[i];
        }

        for (int i = 3; i < chars.length; i++) {
            sum2 += (int) chars[i];
        }

        if (Math.abs(sum1 - sum2) == 0) {
            System.out.println(0);
        }
        else if (Math.abs(sum1 - sum2)<=10) {
            System.out.println(1);
        } else if (Math.abs(sum1 - sum2) <= 20) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
