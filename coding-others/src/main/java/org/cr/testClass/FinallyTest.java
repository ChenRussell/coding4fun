package org.cr.testClass;

public class FinallyTest {

    static int f(int n) {
        try {
//            return ++n;
            return f2(n);   // ���return n++; ���ص���n�����᷵�ؼ�һ
        } catch (Exception e) {

        }finally {
            n = 50;
        }
        return -1;
    }

    private static int f2(int n) {
        n = 2;
        return n;
    }

    public static void main(String[] args) {
        int res = f(100);
        System.out.println(res);
    }
}
