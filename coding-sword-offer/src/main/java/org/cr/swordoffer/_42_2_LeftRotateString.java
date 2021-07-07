package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
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
