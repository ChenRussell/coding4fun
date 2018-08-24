package com.nowcoder.campusExam.wangyi;

/**
 * Created by ChenRui on 2018/3/27
 *
 * 求矩形是否重叠
 */
public class Wone {

    boolean checkOverlap(int x1, int y1, int x2, int y2, int n1, int m1, int n2, int m2) {
        if ((x1+x2-x1 > n1) && (n2>x1) && (y2+y2-y1>m2) && (m2+m2-m1>y2))
            return true;
        else return false;

    }

    public static void main(String[] args) {
        Wone wone = new Wone();
        boolean b = wone.checkOverlap(0, 0, 100, 100, 90, 90, 200, 200);
        System.out.println(b);
    }
}
