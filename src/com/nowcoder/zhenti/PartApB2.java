/**
 * 1016. 部分A+B (15)
 时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
 题目描述
 正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。例如：给定A = 3862767，DA = 6，则A的“6部分”PA是66，因为A中有2个6。

 现给定A、DA、B、DB，请编写程序计算PA + PB。

 输入描述:
 输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0 < A, B < 1010。


 输出描述:
 在一行中输出PA + PB的值。

 输入例子:
 3862767 6 13530293 3

 输出例子:
 399
 */
package com.nowcoder.zhenti;

import java.util.Scanner;

public class PartApB2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a,pa,b,pb;
        a = sc.nextInt();
        pa = sc.nextInt();
        b = sc.nextInt();
        pb = sc.nextInt();
        String A = String.valueOf(a);
        String PA = String.valueOf(pa);
        String B = String.valueOf(b);
        String PB = String.valueOf(pb);
        char cha[] = A.toCharArray();
        char chb[] = B.toCharArray();
        String str1="",str2="";
        for (int i=0;i<cha.length;i++) {
            if(String.valueOf(cha[i]).equals(PA)){
                str1+=String.valueOf(cha[i]);
            }
        }
        for (int i=0;i<chb.length;i++) {
            if(String.valueOf(chb[i]).equals(PB)){
                str2+=String.valueOf(chb[i]);
            }
        }
        if(str1.equals("")) str1="0";
        if(str2.equals("")) str2="0";
        System.out.print(Integer.parseInt(str1)+Integer.parseInt(str2));
    }
}

