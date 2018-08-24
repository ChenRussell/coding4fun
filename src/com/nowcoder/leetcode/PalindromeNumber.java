package com.nowcoder.leetcode;

/**
 * Created by ChenRui on 18-3-11
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0, j = len - 1; i < len && j >= 0 && i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        // special case:
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int res = 0;
        while (x > res) {
            res = 10 * res + x % 10;
            x = x / 10;
        }

        return (x == res || x == res / 10);
    }

    // 反转一遍.比较是否相等
    public boolean isPalindrome3(int x) {
        int x2 = x;
        int res = 0;
        while (x > 0) {
            res = 10 * res + x % 10;
            x = x / 10;
        }
        return x2 == res;
    }

    public static void main(String[] args) {
        PalindromeNumber obj = new PalindromeNumber();
        boolean res = obj.isPalindrome3(1232);
        System.out.println(res);
    }
}
