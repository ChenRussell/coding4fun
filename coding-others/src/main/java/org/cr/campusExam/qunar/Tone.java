package org.cr.campusExam.qunar;

/**
 * Created by ChenRui on 2018/4/2
 * ѡ���⣬��1��2018�ĺ�
 */
public class Tone {

    static int func(int n) {
        if (n > 0) {
            return n + func(n - 1);
        }
        else return 0;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int res = func(2018);
        System.out.println(res);
    }
}
