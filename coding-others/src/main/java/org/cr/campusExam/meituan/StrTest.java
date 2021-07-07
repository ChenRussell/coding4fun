package org.cr.campusExam.meituan;

import java.util.Arrays;

/**
 * Created by ChenRui on 18-4-1
 *
 * 58����
 * ����Ϊ����������Ӵ����Ӵ���Ԫ��һ��
 */
public class StrTest {

    /**
     * �±�Ϊ�ײ���Ϊβ��ʱ��Խ��
     * @param str
     * @param n
     */
    public void f(String str, int n) {

        if (check(str.substring(0, n)) && (str.charAt(n - 1) != str.charAt(n))) {
            System.out.print("(");
            for (int j = 0; j<n;j++) {
                System.out.print(j+",");
            }
            System.out.println(str.substring(0, n)+")");
        }

        for (int i = 1; i < str.length()-n+1-1; i++) {
            if (check(str.substring(i, i + n)) && (str.charAt(i+n-1)!=str.charAt(i+n)) && (str.charAt(i-1)!=str.charAt(i))) {
//                if (i!=0)
                System.out.print("(");
                for (int j = i; j<i+n;j++) {
                    System.out.print(j+",");
                }
                System.out.println(str.substring(i, i + n)+")");
            }
        }


        int k= str.length()-n+1-1;
        if (check(str.substring(k, k + n)) && (str.charAt(k-1)!=str.charAt(k))) {
            System.out.print("(");
            for (int j = k; j<k+n;j++) {
                System.out.print(j+",");
            }
            System.out.println(str.substring(str.length()-n, str.length())+")");
        }
    }


    boolean check(String string) {

        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        if (chars[0] == chars[chars.length - 1]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new StrTest().f("aaabbbbbccddd" ,3);
//        String str = "bbbbb";
//        System.out.println(str.charAt(7));
    }
}
