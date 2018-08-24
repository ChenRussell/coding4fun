package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-3-8
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public int numberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) { // 由于flag不是无符号数,所以这里判断条件不能是>0 , 应该是!=0
            if ((n&flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    int numberOf1v2(int n) {
        int flag = 1, count=0;
        while (n != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            n = n>>>1;
        }
        return count;
    }

    int numberOf1v3(int n) {
        int flag = 1,count = 0;
        while (n != 0) {
//            if ((n = n & (n - 1)) != 0) {
//                count++;
//            }
            ++count;
            n = n & (n - 1);    // 把一个数减去1,再和原来的数做与运算,会把该整数最右边一个1变成0
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1 obj = new NumberOf1();
        int res = obj.numberOf1(-7);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(-7));
    }
}
