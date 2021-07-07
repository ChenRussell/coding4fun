package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-3-8
 * ��Ŀ����
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * ����:������ȫ�棬���ֱ߽�ֵ
 */
public class _11_Power {
    public double power(double base, int exponent) {
        double result = 1;
        int n = Math.abs(exponent);
        for (int i = 0; i < n; i++) {
            result *= base;
        }
        if (base == 0) return 0;
        if (exponent<0) return 1/result;
        return result;
    }

    public static void main(String[] args) {
        _11_Power power = new _11_Power();
        double res = power.power(0, -2);
        System.out.println(res);
    }
}
