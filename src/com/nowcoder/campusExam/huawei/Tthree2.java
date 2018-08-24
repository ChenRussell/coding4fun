package com.nowcoder.campusExam.huawei;

import java.util.Scanner;

public class Tthree2 {


    /**
     * 大数相乘基本思想，输入字符串，转成char数组，转成int数组。采用分治思想，每一位的相乘;<br>
     * 公式：AB*CD = AC (BC+AD) BD , 然后从后到前满十进位(BD,(BC+AD),AC)。
     *
     * @param str1
     * @param str2
     */
    static String multiply(String str1, String str2) {
        char chars1[] = str1.toCharArray();
        char chars2[] = str2.toCharArray();

        int res[] = new int[chars1.length + chars2.length];
        int num1[] = new int[chars1.length];
        int num2[] = new int[chars2.length];

        for (int i = 0; i < chars1.length; i++)
            num1[i] = chars1[i] - '0';
        for (int i = 0; i < chars2.length; i++)
            num2[i] = chars2[i] - '0';

        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                res[i + j] += num1[i] * num2[j];
            }
        }

        for (int i = res.length - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }

        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < res.length - 1; i++) {
            resStr.append("").append(res[i]);
        }
        return resStr.toString();
    }

    public String multiply2(String num1, String num2) {
        //把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();

        //声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];

        //把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for (int i = 0; i < chars1.length; i++)
            n1[i] = chars1[i] - '0';
        for (int i = 0; i < chars2.length; i++)
            n2[i] = chars2[i] - '0';

        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) result[i + j] += n1[i] * n2[j];
        }

        //满10进位，从后往前满十进位
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        //转成string并返回
        String resultStr = "";
        for (int i = 0; i < result.length - 1; i++) {
            resultStr += "" + result[i];
        }
        return resultStr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        String result = multiply(num1, num2);
        System.out.println(result);
    }
}
