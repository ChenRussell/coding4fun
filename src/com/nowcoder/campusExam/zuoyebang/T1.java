package com.nowcoder.campusExam.zuoyebang;

/**
 * Created by ChenRui on 2018/9/5
 */
public class T1 {

    static int ack(int m, int n) {
        if (m == 0) {
            return n+1;
        } else if (n == 0) {
            return ack(m - 1, 1);
        } else {
            return ack(m - 1, ack(m, n - 1));
        }
    }

    public static void main(String[] args) {
        int res = ack(2, 3);
        System.out.println(res);
    }
}
