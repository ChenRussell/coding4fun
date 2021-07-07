package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * ��Ŀ����
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵�����
 * �������ַ���ģ�����ָ���������������һ���������ַ�����S���������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 */
public class _42_2_LeftRotateString {

    public String leftRotateString(String str,int n) {
        if (str.length() == 0) return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);

        reverse(chars, 0, chars.length - 1 - n);
        reverse(chars, chars.length-1-n+1, chars.length-1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start <= end-1) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        _42_2_LeftRotateString leftRotateString = new _42_2_LeftRotateString();
        String res = leftRotateString.leftRotateString("abcXYZdef", 3);
        System.out.println(res);
    }
}
