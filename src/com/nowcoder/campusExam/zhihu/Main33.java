package com.nowcoder.campusExam.zhihu;

import java.util.Scanner;
public class Main33 {

    //    static int count  = 0;
    static int f(int n, int count) {
        if (n == 0) {
            return count+1;
        } else if (n > 0) {
            return f(n - 1, count)+ f(n - 2, count);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = f(n, 0);
        System.out.println(res);
    }
}
