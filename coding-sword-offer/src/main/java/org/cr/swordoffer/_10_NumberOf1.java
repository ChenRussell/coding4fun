package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-3-8
 * ��Ŀ����
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class _10_NumberOf1 {
    public int numberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) { // ����flag�����޷�����,���������ж�����������>0 , Ӧ����!=0
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
            n = n & (n - 1);    // ��һ������ȥ1,�ٺ�ԭ��������������,��Ѹ��������ұ�һ��1���0
        }
        return count;
    }

    public static void main(String[] args) {
        _10_NumberOf1 obj = new _10_NumberOf1();
        int res = obj.numberOf1(-7);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(-7));
    }
}
