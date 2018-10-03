package com.nowcoder.campusExam.netease;

/**
 * Created by ChenRui on 2018/9/8
 */
public class T {

    public static int f(int x) {
        if (x == 0 || x == 1) {
            return x+1;
        }

        return f(x - 1) + f(x - 2);
    }

    public static void main(String[] args) {
        System.out.println(f(10));
    }
}
